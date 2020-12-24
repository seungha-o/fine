package fine.community.training.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.community.training.model.TrainingVO;
import fine.community.training.service.TrainingService;

/**
 * Servlet implementation class Training_Delete
 */
@WebServlet("/trainingDelete.do")
public class Training_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Training_Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	TrainingVO vo = new TrainingVO();
	TrainingService tService = new TrainingService();
	ServletContext context = getServletContext();
	int no = Integer.parseInt(request.getParameter("no"));
	vo.setTrn_no(no);
	
	String path = context.getRealPath("upload"); 
	tService.TrainingDeleteFileName(vo);
	String Filepath = vo.getMedia();
	
	System.out.println(path);
	File f = new File(path +"\\"+Filepath);
	if(f.exists()){
		f.delete();
		System.out.println("파일 삭제됨");
	}else{
		System.out.println("파일 없음");
	}
	
	
	int result = tService.trainingDelete(vo);
	System.out.println(result);
	
	if(result==1) {
		response.sendRedirect("trmListManager.do");
	}else {
		RequestDispatcher disp = request.getRequestDispatcher("/view/training/fine_training_Detail.jsp?no="+no);
		disp.forward(request, response);
	}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
