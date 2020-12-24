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

@WebServlet("/adoptDetail.do")
public class Adopt_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Adopt_Detail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}
	
	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int adopt_no = Integer.parseInt(request.getParameter("adopt_no"));
			AdoptService qnaService = new AdoptService();
			AdoptVO vo = qnaService.adoptDetail(adopt_no);
			if(vo != null) {
					request.setAttribute("detailList", vo);
					RequestDispatcher disp = request.getRequestDispatcher("/view/adopt/AdoptDetail.jsp");
					disp.forward(request, response);					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
