package fine.member.email.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.service.Service;

@WebServlet("/gmailCheckAction.do")
public class Fine_Gmail_Check_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Fine_Gmail_Check_Action() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		excute(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		excute(request, response);
	}
	protected void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String emailcode = request.getParameter("code");
		
		
		PrintWriter out = response.getWriter();
		String ctx = request.getContextPath();
		
		Service services = new Service();
		try {
			int result = services.emailCodeCheck(emailcode);
			if(result == 0){
				out.println("<script>");
				out.println("alert('이메일 인증에 성공하였습니다.')");
				out.println("location.href='"+ctx+"/findHowMany.do'");
				out.println("</script>");
			} else{
				out.println("<script>");
				out.println("alert('이메일 인증을 실패하였습니다.')");
				out.println("location.href='"+ctx+"/findHowMany.do'");
				out.println("</script>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
