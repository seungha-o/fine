package fine.community.quiz.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.community.quiz.model.QuizVO;
import fine.community.quiz.service.QuizService;

@WebServlet("/quizWrite.do")
public class Quiz_Write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Quiz_Write() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String answer = null;
		String quiz_content = request.getParameter("content");
		if(request.getParameter("answer").equals("O")) {
			answer = "0";
			
		}else if(request.getParameter("answer").equals("X")) {
			answer = "1";
		}
		
		QuizService qservice = new QuizService();
		QuizVO vo = new QuizVO();
		vo.setQuiz_content(quiz_content);
		vo.setAnswer(answer);
		int result = qservice.quizWrite(vo);
		System.out.println(result);
		if(result==1) {
			response.sendRedirect("qzmListManager.do");
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("./view/quiz/fine_quiz_Write.jsp");
			disp.forward(request, response);
		}
		
	
	
	
	}

}
