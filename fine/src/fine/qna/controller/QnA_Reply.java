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
		String id = (String) request.getSession().getAttribute("sessionID");
		
		String qna_title = "댓글입니다.";
		String qna_content = request.getParameter("comments");
		String ref = request.getParameter("qna_no");
		String ref_step = request.getParameter("ref_step");
		if(ref_step == null) {
		ref_step = request.getParameter("ref_sub_step");
		}
		
		String ref_level = request.getParameter("ref_level");
		System.out.println("asdasdasdasasd"+ref_level);
		if(ref_level == null) {
			ref_level = request.getParameter("ref_sub_level");
			System.out.println("asdasdasdasasd"+ref_level);
		}
		
	
		
		
		QnAService qnaService = new QnAService();
		int result = qnaService.reply(id, qna_title, qna_content, ref, ref_step, ref_level);
		
		if (result == 1) {
			response.sendRedirect("./qnaDetail.do?qna_no="+ref);
		} else {
			System.out.println("Fail");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
