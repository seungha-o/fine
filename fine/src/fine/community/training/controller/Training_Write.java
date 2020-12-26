package fine.community.training.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
@WebServlet("/trainingWrite.do")
public class Training_Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fileSavePath = "/upload";
	private int uploadSizeLimit = 5000 * 1024 * 1024;
	private String encType = "UTF-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Training_Write() {
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
		 // 파일 저장 경로 (web 경로 밑에 해당 폴더를 생성해 주어야 한다)
		
		
		 // 파일 크기 10M 제한
		
		 
		 //enctype="multipart/form-data" 로 전송되었는지 확인
		 if(!ServletFileUpload.isMultipartContent(request))
			 response.sendRedirect("view/error/Error.jsp");

			 ServletContext context = getServletContext();
			 String uploadPath = context.getRealPath(fileSavePath);
			 System.out.println(uploadPath);
			 MultipartRequest multi = new MultipartRequest(request, // request 객체
			 uploadPath, // 서버 상 업로드 될 디렉토리
			 uploadSizeLimit, // 업로드 파일 크기 제한
			 encType, // 인코딩 방법
			 new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
			 );
			 
			 
//			 //받아온 파일을 하나씩 꺼냄
//			 Enumeration<?> params = multi.getParameterNames();
//			 while(params.hasMoreElements()) {
//				 String name = (String) params.nextElement();
//				 String value = multi.getParameter(name);
//				 System.out.println(name+":"+value);
//			 }
//			 
			 //전송된 파일 정보를 가져옴
//			 Enumeration<?> files = multi.getFileNames();
//			 while(files.hasMoreElements()) {
//				 String name = (String) files.nextElement(); //input file호 된 name = xxx
//				 String values = multi.getFilesystemName(name);//서버에 저장된 파일이름 이걸 vo에 넣어주면됨
//				 String original = multi.getOriginalFileName(name);//전송된 파일의 타입
//				 String type = multi.getContentType(name);//name을 이용해서 파일 객체 생성
//				 File f = multi.getFile(name);
//				 if(f==null) {
//					 
//					 System.out.println("파일 업로드 실패");
//				 }else {
//					 System.out.println(f.length());
//					 
//				 }
//				 System.out.println(name+":"+values+":"+original+":"+type+":"+f);
//				 
//			 }
//			 
			 
			 
			 
			 
			 // 업로드 된 파일 이름 얻어오기
			 String file = multi.getFilesystemName("uploadFile");
			 System.out.println(file);

	
		 
		 String title =  multi.getParameter("title");
		 System.out.println(title);
		 String content = multi.getParameter("content");
		 System.out.println(content);
		if(title != null && !title.equals("") && content!=null && !content.equals("")) {
			System.out.println("들어오냐?");
			TrainingService tService = new TrainingService();
			TrainingVO vo = new TrainingVO();		
			vo.setTrn_title(title);
			vo.setContent(content);
			vo.setMedia(file);
			System.out.println("vo저장");
			int result = tService.trainingWrite(vo);
			System.out.println(result);
			if(result==1) {
				response.sendRedirect("trmListManager.do");
			}else {
				RequestDispatcher disp = request.getRequestDispatcher("/view/training/fine_training_Write.jsp");
				disp.forward(request, response);
			}
		}
	}

}
