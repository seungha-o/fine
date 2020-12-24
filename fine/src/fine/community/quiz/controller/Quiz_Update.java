package fine.community.quiz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.community.quiz.model.QuizVO;
import fine.community.quiz.service.QuizService;

@WebServlet("/quizUpdate.do")
public class Quiz_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Quiz_Update() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String ctxPath = request.getContextPath();
		int no = Integer.parseInt(request.getParameter("no"));
		String content = request.getParameter("content");
		String answer = null;
		if(request.getParameter("answer").equals("O")) {
			answer = "0";
		}else if(request.getParameter("answer").equals("X")) {
			answer = "1";
		}
		QuizVO vo = new QuizVO();
		vo.setQuiz_no(no);
		vo.setQuiz_content(content);
		vo.setAnswer(answer);

		QuizService qservice = new QuizService();
		int result = qservice.quizUpdate(vo);
		System.out.println(result);
		if(result == 0) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('업데이트를 실패 하였습니다.')</script>");
			response.sendRedirect("Quiz_List_manager.do");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('업데이트를 성공 하였습니다.')</script>");
//			response.sendRedirect("Quiz_List_manager.do");
			out.println("<script>location.href='"+ctxPath+"/qzmListManager.do'</script>");
//			out.println("<script>location.href='/community/quiz/controller/qzmListManager.do'</script>");
		}
	}
}
