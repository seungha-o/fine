package fine.adopt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.adopt.service.AdoptService;

@WebServlet("/adoptDelete")
public class Adopt_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Adopt_Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdoptService qnaService = new AdoptService();
		int adopt_no = Integer.parseInt(request.getParameter("adopt_no"));
		try {
			int result = qnaService.adoptDelete(adopt_no);
			if(result == 1) {
				response.sendRedirect("adoptList.do");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
