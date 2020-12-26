package fine.find.findInfo.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
 * Servlet implementation class Find_manage_delete
 */
@WebServlet("/find_manage_delete.do")
public class Find_manage_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find_manage_delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FindVO vo = new FindVO();
		FindService fService = new FindService();
		ServletContext context = getServletContext();
		String no = request.getParameter("no");
		vo.setDesertionNo(no);
		
		String path = context.getRealPath("upload\\dog"); 
		fService.FindDeleteFileName(vo);
		String filepath = vo.getFilename();
		filepath.substring(11);
		System.out.println("filepath : "+filepath);
		
		System.out.println(path);
		File f = new File(path +"\\"+filepath);
		if(f.exists()){
			f.delete();
			System.out.println("파일 삭제됨");
		}else{
			System.out.println("파일 없음");
		}
		
		
		int result = fService.FindDelete(vo);
		System.out.println(result);
		
		if(result==1) {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('삭제가 완료 되었습니다.')</script>");
			response.sendRedirect("fine_find_manage_List.do");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('삭제를 실패 하였습니다.')</script>");
			response.sendRedirect("fine_find_manage_List.do");
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
