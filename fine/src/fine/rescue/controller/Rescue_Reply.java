package fine.rescue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.rescue.service.RescueService;

@WebServlet("/rescueReply.do")
public class Rescue_Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Rescue_Reply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String rec_title = request.getParameter("title");
		String rec_content = request.getParameter("content");
		String ref = request.getParameter("ref");
		String ref_step = request.getParameter("ref_step");
		String ref_level = request.getParameter("ref_level");
		
		RescueService adoptService = new RescueService();
		int result = adoptService.reply(id, rec_title, rec_content, ref, ref_step, ref_level);
		
		if (result == 1) {
			response.sendRedirect("./rescueList.do");
		} else {
			System.out.println("Fail");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
