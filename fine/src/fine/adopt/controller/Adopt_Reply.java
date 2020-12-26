package fine.adopt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.adopt.service.AdoptService;

@WebServlet("/adoptReply.do")
public class Adopt_Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Adopt_Reply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getSession().getAttribute("sessionID");
		String adopt_title = "댓글입니다.";
		String adopt_content = request.getParameter("comments");
		String ref = request.getParameter("adopt_no");
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
		
		AdoptService adoptService = new AdoptService();
		int result = adoptService.reply(id, adopt_title, adopt_content, ref, ref_step, ref_level);
		
		if (result == 1) {
			response.sendRedirect("./adoptDetail.do?adopt_no="+ref);
		} else {
			System.out.println("Fail");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
