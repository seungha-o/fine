package fine.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.qna.model.QnAVO;
import fine.qna.service.QnAService;

@WebServlet("/qnaReply_view.do")
public class QnA_Reply_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnA_Reply_view() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qna_no = request.getParameter("qna_no");
		QnAService qnaService = new QnAService();
		QnAVO vo = qnaService.reply_view(qna_no);
		
		request.setAttribute("reply_view", vo);
		RequestDispatcher disp = request.getRequestDispatcher("./view/qna/QnAReply_view.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
