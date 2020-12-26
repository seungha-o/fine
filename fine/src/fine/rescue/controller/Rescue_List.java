package fine.rescue.controller;

// QnAService qnaService = new QnAService();
//try {
//	List<QnAVO> list = qnaService.qnaList();
//	if (list != null) {
//		request.setAttribute("qnaList", list);
//		RequestDispatcher disp = request.getRequestDispatcher("/qna/QnAList.jsp");
//		disp.forward(request, response);
//	} else {
//		System.out.println("Oh My GOD");
//	}
//} catch (Exception e) {
//	e.printStackTrace();
//}
import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import fine.rescue.model.RescueVO;
import fine.rescue.service.RescueService;

@WebServlet("/rescueList.do")
public class Rescue_List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Rescue_List() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RescueService rescueService = new RescueService();
		int pageSize = 10; // 페이지 당 글 수
		int pageBlock = 10; // 페이지 링크 수
		try {
			// 총 글 개수
			int nCount = RescueService.getBoardCount();
			System.out.println(nCount);
			// 페이지 수 초기화
			String pageNum = request.getParameter("pageNum");
			if (pageNum == null) {
				pageNum = "1";
			} else if (pageNum.equals("")) {
				pageNum = "1";
			}
			// startPage , endPage 구하는 식
			int currentPage = Integer.parseInt(pageNum);

			int pageCount = (nCount / pageSize) + (nCount % pageSize == 0 ? 0 : 1);
			int startPage = 1;
			int endPage = 1;
			if (currentPage % pageBlock == 0) {
				startPage = ((currentPage / pageBlock) - 1) * pageBlock + 1;
			} else {
				startPage = ((currentPage / pageBlock)) * pageBlock + 1;
			}
			endPage = startPage + pageBlock - 1;
			if (endPage > pageCount) {
				endPage = pageCount;
			}
			// 페이징 rownum 구하기
			int startRnum = ((currentPage - 1) * pageSize) + 1; // 거의 공식
			int endRnum = startRnum + pageSize - 1; // currentPage*pageSize
			System.out.println(startRnum + " - " + endRnum);
			List<RescueVO> list = RescueService.rescueList(startRnum, endRnum);

			// 보내주기
			String lev = (String) request.getSession().getAttribute("memberLev");
			String  id = (String) request.getSession().getAttribute("sessionID");

			request.setAttribute("id", id);
			request.setAttribute("level", lev);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("PageNum", currentPage);
			request.setAttribute("currentPage", currentPage); 
			request.setAttribute("count", nCount);
			request.setAttribute("pagecount", pageCount);

			request.setAttribute("adoptList", list);
			RequestDispatcher disp = request.getRequestDispatcher("./view/rescue/RescueList.jsp");
			disp.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
