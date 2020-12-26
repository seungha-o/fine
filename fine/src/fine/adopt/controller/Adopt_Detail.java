package fine.adopt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.adopt.model.AdoptVO;
import fine.adopt.service.AdoptService;
import fine.qna.model.QnAVO;

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
			AdoptService qnaService = new AdoptService();
			String id = (String) request.getSession().getAttribute("sessionID");
			String level = (String) request.getSession().getAttribute("memberLev");
			int adopt_no = Integer.parseInt(request.getParameter("adopt_no"));
			AdoptVO vo = qnaService.adoptDetail(adopt_no);
			List<AdoptVO> list = new ArrayList<AdoptVO>();
			list = qnaService.getComent(adopt_no);
			String member_id = vo.getId();
			if(vo != null) {
				request.setAttribute("list", list);
				request.setAttribute("id", id);
				request.setAttribute("member_id", member_id);
				request.setAttribute("level", level);

					request.setAttribute("detailList", vo);
					RequestDispatcher disp = request.getRequestDispatcher("./view/adopt/AdoptDetail.jsp");
					disp.forward(request, response);					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
