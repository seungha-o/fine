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

@WebServlet("/qnaDetailToUpdate.do")
public class QnA_DetailToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnA_DetailToUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
//			String level = (String) request.getSession().getAttribute("sessionID");
			int strQna_no = Integer.parseInt(request.getParameter("qna_no"));
			QnAService qnaService = new QnAService();
			QnAVO vo = qnaService.qnaDetail(strQna_no);
			if(vo != null) {
				String id = (String) request.getSession().getAttribute("sessionID");
				request.setAttribute("updateList", vo);
				request.setAttribute("id", id);
				RequestDispatcher disp = request.getRequestDispatcher("./view/qna/QnAUpdate.jsp");
				disp.forward(request, response);
			} else {
				System.out.println("Oh My GOD");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
