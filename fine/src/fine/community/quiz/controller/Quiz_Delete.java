package fine.community.quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.community.quiz.model.QuizVO;
import fine.community.quiz.service.QuizService;

/**
 * Servlet implementation class Quiz_Delete
 */
@WebServlet("/quizDelete.do")
public class Quiz_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Quiz_Delete() {
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
		String content = request.getParameter("quiz_content");
		String answer = request.getParameter("answer");
		
		QuizVO vo = new QuizVO();
			vo.setQuiz_no(no);
			vo.setQuiz_content(content);
			vo.setAnswer(answer);
		
		QuizService qservice = new QuizService();
		int result = qservice.quizDelete(vo);
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		if(result==1) {
			out.println("<script>alert('삭제가 완료 되었습니다'); location.href='qzmListManager.do';</script>");
			out.flush();
//			response.sendRedirect("");
		} else {
			out.println("<script>alert('삭제에 실패 하였습니다'); location.href='./view/quiz/fine_quiz_Detail.jsp?no='+no;</script>");
//			out.flush();
//			RequestDispatcher disp = request.getRequestDispatcher("/quiz/fine_quiz_Detail.jsp?no="+no);
//			disp.forward(request, response);
		}
	}

}
