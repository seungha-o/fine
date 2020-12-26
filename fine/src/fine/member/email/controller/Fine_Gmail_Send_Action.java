package fine.member.email.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/gmailSendAction.do")
public class Fine_Gmail_Send_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Fine_Gmail_Send_Action() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		excute(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		excute(request, response);
	}
	protected void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String ctx = request.getContextPath();
		String host = "http://localhost:8090/fine/";		
		String from = "iop800015@gmail.com";
		String to = request.getParameter("email");
		String code = SHA256.getEncrypt(to, "cos");
		PrintWriter out = response.getWriter();

		//사용자에게 보낼 메시지
		String subject = "회원가입을 위한 이메일 인증 메일입니다.";
		HttpSession session = request.getSession();
		String content = "다음 링크에 접속하여 이메일 인증을 진행해주세요. " 
		        + "<a href='" + host + "gmailCheckAction.do?code=" + code
				+ "'>이메일 인증하기</a>";

		Properties p = new Properties();
		p.put("mail.smtp.user", from);
		p.put("mail.smtp.host", "smtp.googlemail.com");
		p.put("mail.smtp.port", "465"); //TLS 587, SSL 465
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465"); 
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.sockerFactory.fallback", "false");

		try {
			Authenticator auth = new Fine_Gmail_Info();
			Session ses = Session.getInstance(p, auth);
			ses.setDebug(true);
			MimeMessage msg = new MimeMessage(ses);
			msg.setSubject(subject);
			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/html; charset=UTF8");
			Transport.send(msg);
			out.println("<script>alert('이메일이 발송되었습니다 인증후 로그인해주세요.')</script>");
			out.println("<script>location.href='"+ctx+"/findHowMany.do'</script>");
//			response.sendRedirect(ctx+"/index.jsp");
			
		} catch (Exception e) {
			out.println("<script>");
			out.println("alert('이메일 인증 오류')");
			out.println("history.back();");
			out.println("</script>");
		}
	}
}
