package fine.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.qna.service.QnAService;

@WebServlet("/qnaReply.do")
public class QnA_Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnA_Reply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String qna_title = request.getParameter("title");
		String qna_content = request.getParameter("content");
		String pass = request.getParameter("pass");
		String ref = request.getParameter("ref");
		String ref_step = request.getParameter("ref_step");
		String ref_level = request.getParameter("ref_level");
		
		QnAService qnaService = new QnAService();
		int result = qnaService.reply(id, qna_title, qna_content, pass, ref, ref_step, ref_level);
		
		if (result == 1) {
			response.sendRedirect("./qnaList.do");
		} else {
			System.out.println("Fail");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
