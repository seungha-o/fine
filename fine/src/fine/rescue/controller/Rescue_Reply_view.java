package fine.rescue.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.rescue.model.RescueVO;
import fine.rescue.service.RescueService;

@WebServlet("/rescueReply_view.do")
public class Rescue_Reply_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Rescue_Reply_view() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rec_no = request.getParameter("rec_no");
		RescueService qnaService = new RescueService();
		RescueVO vo = qnaService.reply_view(rec_no);
		
		request.setAttribute("reply_view", vo);
		RequestDispatcher disp = request.getRequestDispatcher("./view/rescue/RescueReply_view.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
