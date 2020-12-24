package fine.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.qna.service.QnAService;

@WebServlet("/qnaDelete")
public class QnA_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnA_Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnAService qnaService = new QnAService();
		int qna_no = Integer.parseInt(request.getParameter("qna_no"));
		try {
			int result = qnaService.qnaDelete(qna_no);
			if(result == 1) {
				response.sendRedirect("qnaList.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
