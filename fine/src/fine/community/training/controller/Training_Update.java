package fine.community.training.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
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
@WebServlet("/trainingUpdate.do")
public class Training_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Training_Update() {
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
		TrainingVO vo = new TrainingVO();
		TrainingService tService = new TrainingService();
		ServletContext context = getServletContext();
		vo.setTrn_no(no);
		
		
		
		 String fileSavePath = "/upload";
		 // 파일 크기 10M 제한
		 int uploadSizeLimit = 10 * 1024 * 1024;
		 String encType = "UTF-8";
		 
		 if(!ServletFileUpload.isMultipartContent(request))
			 response.sendRedirect("/view/error/Error.jsp");
			 String uploadPath = context.getRealPath(fileSavePath);
			 System.out.println(uploadPath);
			 MultipartRequest multi = new MultipartRequest(request, // request 객체
			 uploadPath, // 서버 상 업로드 될 디렉토리
			 uploadSizeLimit, // 업로드 파일 크기 제한
			 encType, // 인코딩 방법
			 new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
			 );
			 String file = multi.getFilesystemName("uploadFile");
			 System.out.println(file);
		
		String path = context.getRealPath("upload"); 
		tService.TrainingDeleteFileName(vo);
		String filepath = vo.getMedia();
		System.out.println(filepath +"=============================================");
		System.out.println(path);
		File f = new File(path +"\\"+filepath);
		if(file!=null) {
			if(f.exists()){
				f.delete();
				System.out.println("파일 삭제됨");
			}else{
				System.out.println("파일 없음");
			}
		}
		
		
			 String title =  multi.getParameter("title");
			 System.out.println(title);
			 String content = multi.getParameter("content");
			 System.out.println(content);
			 if(title != null && !title.equals("") && content!=null && !content.equals("")) {
				vo.setTrn_title(title);
				vo.setContent(content);
				vo.setMedia(file);
				System.out.println("===================================================");
				System.out.println("vo저장");
				int result = tService.trainingUpdate(vo);
				System.out.println(result);
				if(result==1) {
					response.sendRedirect("trmListManager.do");
				}else {
				System.out.println("실패");
				}
				
			 }
	}
}
