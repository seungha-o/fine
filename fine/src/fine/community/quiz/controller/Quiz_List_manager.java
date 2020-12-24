package fine.community.quiz.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.community.quiz.model.QuizDAO;
import fine.community.quiz.model.QuizVO;
import fine.community.quiz.service.QuizService;

@WebServlet("/qzmListManager.do")
public class Quiz_List_manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Quiz_List_manager() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		 
			int pageSize = 10; // 페이지당 읽어올 글수
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			int pageBlock = 10;
		

		QuizDAO dao = new QuizDAO();
		int count = dao.getBoardCount();
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);


		int pagecount = (count / pageSize) + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1;
		int endPage = 1;
		if (currentPage % 10 == 0) {

			startPage = ((currentPage / 10) - 1) * pageBlock + 1;
			
		} else {
			startPage = ((currentPage / 10)) * pageBlock + 1;
		}

		endPage = startPage + pageBlock;
		if (endPage > pagecount) {
			endPage = pagecount;
		}

		int startRnum = (currentPage - 1) * pageSize + 1;
		int endRnum = startRnum + pageSize - 1;
		System.out.println(startRnum);
		System.out.println(endRnum);
		System.out.println(currentPage);
		
		request.setAttribute("currentPage", currentPage); 
		request.setAttribute("count", count);
		request.setAttribute("endPage", endPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pagecount", pagecount);
		QuizService qService = new QuizService();
		List<QuizVO> list = new ArrayList<QuizVO>();
		list = qService.getQuizList(startRnum, endRnum);
		request.setAttribute("list", list);
		RequestDispatcher dis = request.getRequestDispatcher("./view/quiz/fine_quiz_manage_List.jsp");
		dis.forward(request, response);
	
	}

}
