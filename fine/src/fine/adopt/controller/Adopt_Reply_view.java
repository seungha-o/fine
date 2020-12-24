package fine.adopt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.adopt.model.AdoptVO;
import fine.adopt.service.AdoptService;

@WebServlet("/adoptReply_view.do")
public class Adopt_Reply_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Adopt_Reply_view() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adopt_no = request.getParameter("adopt_no");
		AdoptService qnaService = new AdoptService();
		AdoptVO vo = qnaService.reply_view(adopt_no);
		
		request.setAttribute("reply_view", vo);
		RequestDispatcher disp = request.getRequestDispatcher("/view/adopt/AdoptReply_view.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
