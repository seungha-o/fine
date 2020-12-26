package fine.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.member.model.MemberVO;
import fine.member.member.model.MembersService;



@WebServlet("/Update.do")
public class Fine_MyPage_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Fine_MyPage_Update() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {				
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		execute(request, response);
	}


	private void execute(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = (String)request.getSession().getAttribute("sessionID");
		String password = request.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		
		PrintWriter out = response.getWriter();
		String ctxPath = request.getContextPath();
		
		MembersService services = new MembersService();
		int result = services.PwCheck2(id ,password);
		
			if (result == 1) { //성공
				
				String dog_kind_no = request.getParameter("kind");
				System.out.println("kind : "+dog_kind_no);
				String address = request.getParameter("address");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				
				MemberVO vo =new MemberVO();
				vo.setDog_kind_no(dog_kind_no);
				vo.setAddress(address);
				vo.setPhone(phone);
				vo.setEmail(email);
				try {
					System.out.println("a11");
					int result2 = services.updateMember(vo, id);
					if(result2==1) {
						System.out.println("업데이이트 서블릿:" + result2 );
						response.sendRedirect("./MyPage.do"); 
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}else if (result == 0){		//실패
				out.println("<script>alert('비밀번호를 다시 확인해주세요.');</script>");
				out.println("<script>location.href=history.back()</script>");	
			} 		
			System.out.println("a4");
			out.flush();
			out.close();

	}
		
		
	/*
	 * try { MemberVO vo =new MemberVO(); if(vo != null &&
	 * vo.getPassword().equals(password)) {//password값이 기존과 동일하면 수정
	 * vo.setDog_kind_no(request.getParameter("dog_kind_no"));
	 * vo.setAddress(request.getParameter("address"));
	 * vo.setPhone(request.getParameter("phone"));
	 * vo.setEmail(request.getParameter("email"));
	 * vo.setId(request.getParameter("id"));
	 * 
	 * MembersService services = new MembersService(); int result =
	 * services.updateMember(vo, id, password); if(result==1) {
	 * System.out.println("업데이이트 서블릿:" + result );
	 * response.sendRedirect("/member/myPageView.jsp"); }else {
	 * request.getRequestDispatcher("/member/myPageUpdate.jsp").forward(request,
	 * response); } } } catch (NumberFormatException e) {
	 * request.getRequestDispatcher("/member/myPageUpdate.jsp").forward(request,
	 * response); } catch (NullPointerException e) {
	 * request.getRequestDispatcher("/member/myPageUpdate.jsp").forward(request,
	 * response); } catch (SQLException e) { e.printStackTrace();
	 * request.getRequestDispatcher("/member/myPageUpdate.jsp").forward(request,
	 * response); }
	 * 
	 * 
	 * 
	 * }
	 */
}
