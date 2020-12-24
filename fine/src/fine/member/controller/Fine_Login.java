package fine.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.member.model.MemberVO;
import fine.member.service.Service;

@WebServlet("/login.do")
public class Fine_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Fine_Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		excute(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		excute(request, response);
	}
	protected void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		System.out.println(pw);
		PrintWriter out = response.getWriter();
		String ctxPath = request.getContextPath();
		Service services = new Service();
		int result = services.login(id , pw);
		
		if(result == 1) {
			String lev = services.memberLev(id);
			System.out.println(lev);
			request.getSession().setAttribute("memberLev", lev);
			request.getSession().setAttribute("sessionID", id);
			request.setAttribute("result", result);
			out.println("<script>alert('로그인성공');</script>");
			out.println("<script>location.href='"+ctxPath+"/view/main/index.jsp'</script>");
		} else if(result == 0) {
			out.println("<script>alert('비밀번호를 확인해주세요.');</script>");
			out.println("<script>location.href='"+ctxPath+"/view/member/Fine_Member_Login.jsp'</script>");
		} else if(result == -1) {
			out.println("<script>alert('존재하지 않는 아이디입니다.');</script>");
			out.println("<script>location.href='"+ctxPath+"/view/member/Fine_Member_Login.jsp'</script>");
		}
		
		out.flush();
		out.close();
	}
}
