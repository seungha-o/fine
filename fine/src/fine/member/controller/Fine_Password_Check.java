package fine.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.service.Service;

@WebServlet("/findPW.do")
public class Fine_Password_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Fine_Password_Check() {
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
		PrintWriter out = response.getWriter();
		String ctx = request.getContextPath();
		
		String eid = request.getParameter("eid");
		String eweb = request.getParameter("eweb");
		String email = eid+"@"+eweb;
		String id = request.getParameter("id");
		System.out.println(email);
		Service services = new Service();
		try {
			int result = services.findPw(email,id);
			if(result==1) {
				request.getRequestDispatcher("/sendPassword.do").forward(request, response);
			}else {
				out.println("<script>alert('아이디 또는 이메일이 일치하지않습니다.')</script>");
				out.println("<script>location.href=('"+ctx+"/view/member/Fine_Member_Find.jsp')</script>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
