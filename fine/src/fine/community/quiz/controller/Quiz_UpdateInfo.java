package fine.community.quiz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.community.quiz.model.QuizVO;
import fine.community.quiz.service.QuizService;

@WebServlet("/quizUpdateInfo.do")
public class Quiz_UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Quiz_UpdateInfo() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		
		QuizService qservice = new QuizService();
		List<QuizVO> list = new ArrayList<QuizVO>();
		list = qservice.getQuizInfo(no);
		
		request.setAttribute("list", list);
		RequestDispatcher disp = request.getRequestDispatcher("./view/quiz/fine_quiz_Update.jsp?no="+no);
		disp.forward(request, response);
		
	}
}
