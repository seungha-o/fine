package fine.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.member.model.MemberVO;
import fine.member.member.model.MembersService;




@WebServlet("/MyPage.do")
public class Fine_MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public Fine_MyPage() {
        super();     
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		execute(request, response);		
	}	
	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String ctx = request.getContextPath();
		System.out.println("마이페이지 서블릿");
		String lev = (String)request.getSession().getAttribute("memberLev");
		String id = (String)request.getSession().getAttribute("sessionID");
		System.out.println(lev);
		MembersService services = new MembersService();
		if(id == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 후 이용해 주세요')</script>");
			out.println("<script>location.href='"+ctx+"/findHowMany.do'</script>"); 
		}
		if(lev.equals("1") || lev.equals("2")) {// 관리자가 아니면  보인 mypage만 보여줌
			List<MemberVO> myPageList=services.MyPageList(lev,id); // list에 뿌려줄 DATA 를 받아옴
			request.setAttribute("myPageList", myPageList);  // 위 받아온 list를  memberVoList이름에다가 실어줌.
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("./view/member/myPageView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			/*
			 * List<MemberVO> myPageList=services.MyPageListAdmin(); // list에 뿌려줄 DATA 를 받아옴
			 * System.out.println(myPageList.size()); request.setAttribute("myPageList",
			 * myPageList);
			 */
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/member/myPageAdmin.jsp");
//			dispatcher.forward(request, response);
			
			response.sendRedirect("./myPageList.do"); 
		}
	}
	
}
