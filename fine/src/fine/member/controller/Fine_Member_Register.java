package fine.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.email.controller.SHA256;
import fine.member.member.model.MemberVO;
import fine.member.service.Service;

//회원가입을 위한 레지스터 서블릿입니다
@WebServlet("/register.do")
public class Fine_Member_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Fine_Member_Register() {
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
		
		String id = request.getParameter("id");
		String[] ck = request.getParameterValues("careCK");
		String care_no = request.getParameter("care_no");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String year = request.getParameter("years");
		String month = request.getParameter("months");
		String day = request.getParameter("days");
		String dog_kind_no = request.getParameter("dog_kind_no");
		String address = request.getParameter("address");
		if(ck == null) {
			ck = new String[1];
			ck[0] = "0";
		}
		String now = year+"-"+month+"-"+day;
		Date birthday = Date.valueOf(now); //sql형으로 변환
		System.out.println(birthday);
		int a = Integer.parseInt(ck[0]);
		System.out.println(email);
		MemberVO vo = new MemberVO();
		vo.setId(id);
		System.out.println("1");
		vo.setCare_no(care_no);
		System.out.println("2");
		vo.setName(name);
		System.out.println("3");
		vo.setPassword(pw);
		System.out.println("4");
		vo.setPhone(phone);
		System.out.println("5");
		vo.setEmail(email);
		System.out.println("6");
		vo.setDog_kind_no(dog_kind_no);
		System.out.println("7");
		vo.setBirthday(birthday);
		System.out.println("8");
		vo.setAddress(address);
		System.out.println("9");
		String aaa = SHA256.getEncrypt(email,"cos"); //이메일암호화
		System.out.println("aaa :"+aaa);
		vo.setEmailcode(aaa);
		
		Service services = new Service();
		int result = services.memberRegister(vo,a);
		
		if(result == 1) {
			if(a == 1) {
				out.println("<script> alert('회원가입에 성공하였습니다 관리자의 승인후 이용해주시기바랍니다.')</script>");
				out.println("<script> location.href=('"+ctx+"/view/main/index.jsp')</script>");
			}else {
				
				request.getRequestDispatcher("/gmailSendAction.do").forward(request, response);
			}
		}else {
			out.println("<script> alert('회원가입에 실패하였습니다.')</script>");
			out.println("<script> location.href=('"+ctx+"/view/main/index.jsp')</script>");
		}
	
//		response.sendRedirect(ctx+"/member/gmailSendAction.jsp");
		
//		RequestDispatcher disp = request.getRequestDispatcher("/member/hello.jsp");
//		disp.forward(request, response);
	}
}
