package fine.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.qna.service.QnAService;

/**
 * Servlet implementation class QnA_DetailCheck
 */
@WebServlet("/qnaDetailCheck.do")
public class QnA_DetailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnA_DetailCheck() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnAService qnaService = new QnAService();
		String id = (String) request.getSession().getAttribute("sessionID");
		String level = (String) request.getSession().getAttribute("memberLev");
		int strQna_no = Integer.parseInt(request.getParameter("qna_no"));
		//1이나 0가져오기
		String privateChk = qnaService.privateChk(strQna_no);
		System.out.println(privateChk);
		if(privateChk.equals("1")) {
			RequestDispatcher disp = request.getRequestDispatcher("./view/qna/QnACheckPass.jsp");
			disp.forward(request, response);
		}else {
			RequestDispatcher disp = request.getRequestDispatcher("/qnaDetail.do");
			disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
