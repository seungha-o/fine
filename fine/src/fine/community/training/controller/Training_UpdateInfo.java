package fine.community.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import fine.community.training.model.TrainingVO;
import fine.community.training.service.TrainingService;

/**
 * Servlet implementation class Training_Write
 */
@WebServlet("/trainingUpdateInfo.do")
public class Training_UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Training_UpdateInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		TrainingService tService = new TrainingService(); 
		List<TrainingVO> list = new ArrayList<TrainingVO>();
		list = tService.getTrainingInfo(no); 
		System.out.println(list);
		request.setAttribute("list", list);
		//response.sendRedirect("../training/fine_training_Dtail.jsp?trn_no="+no);
		RequestDispatcher disp = request.getRequestDispatcher("/view/training/fine_training_Update.jsp?no="+no);
		disp.forward(request, response);
	
	}
}
