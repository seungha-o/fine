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

@WebServlet("/qnaDetail.do")
public class QnA_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnA_Detail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int strQna_no = Integer.parseInt(request.getParameter("qna_no"));
			QnAService qnaService = new QnAService();
			QnAVO vo = qnaService.qnaDetail(strQna_no);
			if(vo != null) {
//				if(pass == null) {
					request.setAttribute("detailList", vo);
					RequestDispatcher disp = request.getRequestDispatcher("./view/qna/QnADetail.jsp");
					disp.forward(request, response);					
//				} else {
//					
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
