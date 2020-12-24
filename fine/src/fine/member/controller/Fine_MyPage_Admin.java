package fine.member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.member.model.MemberVO;
import fine.member.member.model.MembersService;




@WebServlet("/myPageList.do")
public class Fine_MyPage_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Fine_MyPage_Admin() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MembersService services = new MembersService();						
		String lev = "3"; 
//		(String)request.getSession().getAttribute("memberLev");
		System.out.println(lev);
		String searchId= request.getParameter("searchid");
		request.setAttribute("lev",lev);
		// 페이징
		int pageSize = 10; // 페이지 당 글 수
		int pageBlock = 10; // 페이지 링크 수
											
						//총 글 개수 
		int nCount = services.getMyPageCount(); /*변경 : 메소드*/
		System.out.println(nCount);
						//페이지 수 초기화
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
				pageNum = "1";
		} else if(pageNum.equals("")){
				pageNum = "1";
				}
		//startPage , endPage 구하는 식
		int currentPage = 1;
		try {
				currentPage = Integer.parseInt(pageNum);
			} catch(Exception e) {
				e.printStackTrace();
				
				}
					
			int pageCount = (nCount / pageSize) + (nCount % pageSize == 0 ? 0 : 1);
			int startPage = 1;
			int endPage = 1;
			if (currentPage % pageBlock == 0) {
					startPage = ((currentPage / pageBlock) - 1) * pageBlock + 1;
			} else {
					startPage = ((currentPage / pageBlock)) * pageBlock + 1;
					}
				endPage = startPage + pageBlock - 1;
					if (endPage > pageCount)
						endPage = pageCount;

						// 페이징 rownum 구하기
					int startRnum = ((currentPage-1)*pageSize)+1;	// 거의 공식
					int endRnum = startRnum + pageSize - 1;			// currentPage*pageSize
					System.out.println(startRnum +  " - "+ endRnum );
					
						//보내주기 
					request.setAttribute("startPage", startPage);
					request.setAttribute("endPage", endPage);
					request.setAttribute("PageNum", currentPage);
					
		            List<MemberVO> myPageList = services.MyPageListAdmin(startRnum , endRnum); // list에 뿌려줄 data를 다 받아왔음
		          
		try {
		
			// 위 받아온 list를 jsp(View)에서 보여줘야 하므로 request 실어서 보내줘야함. --> forward
			if(lev.equals("3")) {
				request.setAttribute("myPageList", myPageList); 
				RequestDispatcher dispatcher = request.getRequestDispatcher("./view/member/myPageAdmin.jsp");
				dispatcher.forward(request, response);
			 }else {
				 RequestDispatcher dispatcher2 = request.getRequestDispatcher("./view/member/error.jsp");
					dispatcher2.forward(request, response); 
			 }
		
		}catch (Exception e) {
			e.printStackTrace();
			//request.setAttribute("errorMsg", "SQL문 장애발생으로 데이터 입력 실패함!!");
			RequestDispatcher dispatcher3 = request.getRequestDispatcher("./view/member/error.jsp");
			dispatcher3.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
