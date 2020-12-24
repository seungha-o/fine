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

@WebServlet("/PhoneCheck")
public class Fine_Phone_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Fine_Phone_Check() {
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
		String phone = request.getParameter("phone");
		PrintWriter out = response.getWriter();
		try {
			Service services = new Service();
			boolean result = services.idCheck(phone);
			if (result == true)
				out.println("이미 사용중인 phone 입니다");
			else
				out.println("사용가능한 phone 입니다");
		} catch (SQLException e) {
			e.printStackTrace();
			out.println("입력범위를 벗어났습니다. 다시 입력해주세요.");
		} catch (Exception e) {
			out.println("조회하는 도중에 오류가 발생했습니다.");
		}
		out.flush();
		out.close();
	}
}