package fine.member.controller;

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

import fine.member.email.controller.Fine_Gmail_Info;
import fine.member.email.controller.SHA256;
import fine.member.service.Service;

@WebServlet("/sendPassword.do")
public class Fine_Send_Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Fine_Send_Password() {
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
		PrintWriter out = response.getWriter();
		
		String ctx = request.getContextPath();
		String host = "http://localhost:8090/semi_/";		
		String from = "wngud1223@gmail.com";
		Fine_Random_Password randpwds = new Fine_Random_Password();
		String randpwd = randpwds.randomPassword(12);
		String a = request.getParameter("eid");
		System.out.println(a);
		String eid = request.getParameter("eid");
		String eweb = request.getParameter("eweb");
		String to = eid+"@"+eweb;
		System.out.println(to);
		//사용자에게 보낼 메시지
				String subject = "FINE 계정의 임시비밀번호 메일입니다.";
				HttpSession session = request.getSession();
				String content = "임시비밀번호는 "+randpwd+" 입니다."; 
				     
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
					out.println("<script>alert('이메일에 임시비밀번호가 발송되었습니다.')</script>");
					Service services = new Service();
					int result = services.changePw(randpwd,to);
					out.println("<script>location.href='"+ctx+"/findHowMany.do'</script>");
					
				} catch (Exception e) {
					out.println("<script>");
					out.println("alert('이메일 인증 오류')");
					out.println("history.back();");
					out.println("</script>");
				}
	}
}
