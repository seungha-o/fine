package fine.community.training.controller;

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

/**
 * Servlet implementation class Training_Detail
 */
@WebServlet("/trainingDetail.do")
public class Training_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Training_Detail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		TrainingService tService = new TrainingService(); 
		List<TrainingVO> list = new ArrayList<TrainingVO>();
		list = tService.getTrainingInfo(no); 
		System.out.println(list);
		request.setAttribute("list", list);
		//response.sendRedirect("../training/fine_training_Dtail.jsp?trn_no="+no);
		RequestDispatcher disp = request.getRequestDispatcher("/view/training/fine_training_Detail.jsp?no="+no);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
