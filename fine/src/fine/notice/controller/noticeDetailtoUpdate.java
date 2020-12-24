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
 * Servlet implementation class noticeDetailtoUpdate
 */
@WebServlet("/noticeDetailtoUpdate.do")
public class noticeDetailtoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeDetailtoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	         int no = Integer.parseInt(request.getParameter("notice_no"));
	         NoticeService nService = new NoticeService();
	         NoticeVO vo = nService.detailNotice(no);
	         if(vo != null) {
	            request.setAttribute("list", vo);
	            RequestDispatcher disp = request.getRequestDispatcher("/view/notice/noticeUpdate.jsp");
	            disp.forward(request, response);
	         } else {
	            System.out.println("Oh My GOD");
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
