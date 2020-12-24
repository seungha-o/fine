package fine.adopt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.adopt.model.AdoptVO;
import fine.adopt.service.AdoptService;

@WebServlet("/adoptSearch.do")
public class Adopt_Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Adopt_Search() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdoptService adoptService = new AdoptService();
		String searchWord = request.getParameter("title");
		int pageSize = 10; // 페이지 당 글 수
		int pageBlock = 10; // 페이지 링크 수
		try {
			// 총 글 개수
			int nCount = AdoptService.getSearchBoardCount(searchWord);
			System.out.println(searchWord);
			System.out.println("nCount" + nCount);
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
			List<AdoptVO> searchList = AdoptService.adoptSearch(searchWord, startRnum, endRnum);
			// 보내주기
			if (searchList != null) {
				request.setAttribute("searchStartPage", startPage);
				request.setAttribute("searchEndPage", endPage);
				request.setAttribute("searchPageNum", currentPage);
				request.setAttribute("count", nCount);
				request.setAttribute("searchWord", searchWord);
				request.setAttribute("searchList", searchList);
				request.setAttribute("pagecount", pageCount);

				System.out.println(searchList.size() + ", " + startPage + ", " + endPage);
				RequestDispatcher disp = request.getRequestDispatcher("/view/adopt/AdoptSearchResult.jsp?pageNum="+currentPage+"&title = "+searchWord);
				disp.forward(request, response);					// ?pageNum="+currentPage+"&title = "+searchWord
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
