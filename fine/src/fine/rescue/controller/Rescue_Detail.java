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

@WebServlet("/rescueDetail.do")
public class Rescue_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Rescue_Detail() {
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
			int rec_no = Integer.parseInt(request.getParameter("rec_no"));
			RescueService qnaService = new RescueService();
			RescueVO vo = qnaService.rescueDetail(rec_no);
			if(vo != null) {
					request.setAttribute("detailList", vo);
					RequestDispatcher disp = request.getRequestDispatcher("./view/rescue/RescueDetail.jsp");
					disp.forward(request, response);					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
