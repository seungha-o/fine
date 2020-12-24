package fine.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.service.Service;

@WebServlet("/findID.do")
public class Fine_Find_ID_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Fine_Find_ID_Check() {
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
		
		String eid = request.getParameter("eid");
		String eweb = request.getParameter("eweb");
		String email = eid+"@"+eweb;
		try {
			Service services = new Service();
			String result = services.findId(email);
			if(result == null) {
				out.println("존제하지 않는 이메일입니다");
			}else {
				out.println(result);
			}
		} catch (Exception e) {
		}
	}
}
