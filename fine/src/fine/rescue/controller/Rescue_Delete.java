package fine.rescue.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.rescue.service.RescueService;

@WebServlet("/rescueDelete")
public class Rescue_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Rescue_Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RescueService qnaService = new RescueService();
		int rec_no = Integer.parseInt(request.getParameter("rec_no"));
		try {
			int result = qnaService.rescueDelete(rec_no);
			if(result == 1) {
				response.sendRedirect("rescueList.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
