package fine.find.findInfo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.community.training.model.TrainingVO;
import fine.community.training.service.TrainingService;
import fine.find.findInfo.model.FindVO;
import fine.find.findInfo.service.FindService;

/**
 * Servlet implementation class Find_Detail
 */
@WebServlet("/findDetail.do")
public class Find_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find_Detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		FindService fService = new FindService(); 
		List<FindVO> list = new ArrayList<FindVO>();
		list = fService.getFindDetail(no); 
		System.out.println(list);
		request.setAttribute("list", list);
		//response.sendRedirect("../training/fine_training_Dtail.jsp?trn_no="+no);
		RequestDispatcher disp = request.getRequestDispatcher("/view/find/fine_find_Detail.jsp");
		disp.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
