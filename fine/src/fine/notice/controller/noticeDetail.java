package fine.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.notice.model.NoticeVO;
import fine.notice.service.NoticeService;


/**
 * Servlet implementation class noticeDetail
 */
@WebServlet("/noticeDetail.do")
public class noticeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public noticeDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int no = Integer.parseInt(request.getParameter("notice_no"));
			NoticeService nservice = new NoticeService();
			NoticeVO vo = nservice.detailNotice(no);
			if (vo != null) {
				request.setAttribute("noticeVO", vo);
				RequestDispatcher disp = request.getRequestDispatcher("/view/notice/noticeDetail.jsp");
				disp.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
