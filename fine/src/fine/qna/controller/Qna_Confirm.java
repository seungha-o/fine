package fine.qna.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.qna.service.QnAService;

/**
 * Servlet implementation class QnaConfirm
 */
@WebServlet("/qnaConfirm.do")
public class Qna_Confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Qna_Confirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		QnAService qnaService = new QnAService();
		int qnaNo = Integer.parseInt(request.getParameter("qna_no"));
		int qnaPass = Integer.parseInt(request.getParameter("pwChk"));
		int passChk = qnaService.qnaPassChk(qnaNo, qnaPass);
		if(passChk == 1) {
			RequestDispatcher disp = request.getRequestDispatcher("/qnaDetail.do");
			disp.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.append("<script>alert('비밀번호가 일치하지 않습니다.')</script>");
			out.println("<script>history.back()</script>");
			out.flush();
			out.close();
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
