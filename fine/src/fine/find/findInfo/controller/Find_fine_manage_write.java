package fine.find.findInfo.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import fine.find.findInfo.model.FindVO;
import fine.find.findInfo.service.FindService;

/**
 * Servlet implementation class Find_fine_manage_write
 */
@WebServlet("/find_fine_manage_write.do")
public class Find_fine_manage_write extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fileSavePath = "/upload/dog";
	private int uploadSizeLimit = 10 * 1024 * 1024;
	private String encType = "UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Find_fine_manage_write() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	
		
		
		
		String checkId = (String) request.getSession().getAttribute("sessionID");;
		
			if (!ServletFileUpload.isMultipartContent(request))
				response.sendRedirect("findHowMany.do");

			ServletContext context = getServletContext();
			String uploadPath = context.getRealPath(fileSavePath);
			System.out.println(uploadPath);
			MultipartRequest multi = new MultipartRequest(request, // request 객체
					uploadPath, // 서버 상 업로드 될 디렉토리
					uploadSizeLimit, // 업로드 파일 크기 제한
					encType, // 인코딩 방법
					new DefaultFileRenamePolicy() // 동일 이름 존재 시 새로운 이름 부여 방식
			);

//							 //받아온 파일을 하나씩 꺼냄
//							 Enumeration<?> params = multi.getParameterNames();
//							 while(params.hasMoreElements()) {
//								 String name = (String) params.nextElement();
//								 String value = multi.getParameter(name);
//								 System.out.println(name+":"+value);
//							 }
//							 
			// 전송된 파일 정보를 가져옴
//							 Enumeration<?> files = multi.getFileNames();
//							 while(files.hasMoreElements()) {
//								 String name = (String) files.nextElement(); //input file호 된 name = xxx
//								 String values = multi.getFilesystemName(name);//서버에 저장된 파일이름 이걸 vo에 넣어주면됨
//								 String original = multi.getOriginalFileName(name);//전송된 파일의 타입
//								 String type = multi.getContentType(name);//name을 이용해서 파일 객체 생성
//								 File f = multi.getFile(name);
//								 if(f==null) {
//									 
//									 System.out.println("파일 업로드 실패");
//								 }else {
//									 System.out.println(f.length());
//									 
//								 }
//								 System.out.println(name+":"+values+":"+original+":"+type+":"+f);
//								 
//							 }
//							 

			// 업로드 된 파일 이름 얻어오기
			String file = multi.getFilesystemName("uploadFile");
			System.out.println(file);

			String happenPlace = multi.getParameter("happenPlace");
			String age = multi.getParameter("age");
			String colorCd = multi.getParameter("colorCd");
			String happenDt = multi.getParameter("happenDt");
			String dogKind = multi.getParameter("dogKind");
			String neuterYn = multi.getParameter("neuterYn");
			String officetel = multi.getParameter("officetel");
			String orgNm = multi.getParameter("orgNm");
			String sexCd = multi.getParameter("sexCd");
			String specialMark = multi.getParameter("happenPlace");
			String weight = multi.getParameter("happenPlace");
			if (happenPlace != null && !happenPlace.equals("") && age != null && !age.equals("") && colorCd != null
					&& !colorCd.equals("") && happenDt != null && !happenDt.equals("") && dogKind != null
					&& !dogKind.equals("") && neuterYn != null && !neuterYn.equals("") 
					&&  officetel != null && !officetel.equals("") && orgNm != null
					&& !orgNm.equals("") && sexCd != null && !sexCd.equals("") && specialMark != null
					&& !specialMark.equals("") && weight != null && !weight.equals("")) {
				System.out.println("들어오냐?");
				FindService fService = new FindService();
				FindVO vo = new FindVO();
				vo.setHappenPlace(happenPlace);
				vo.setAge(age);
				vo.setColorCd(colorCd);
				vo.setHappenDt(happenDt);
				vo.setKindCd(dogKind);
				vo.setNeuterYn(neuterYn);
				vo.setOfficetel(officetel);
				vo.setOrgNm(orgNm);
				vo.setSexCd(sexCd);
				vo.setSpecialMark(specialMark);
				vo.setWeight(weight);
				System.out.println("vo저장");
				int result = fService.FindMangerWrite(checkId,vo, file);
				System.out.println(result);
				if (result == 1) {
					PrintWriter out = response.getWriter();
					out.println("<script>alert('등록이 완료 되었습니다.')</script>");

					response.sendRedirect("fine_find_manage_List.do");
				} else {
					RequestDispatcher disp = request.getRequestDispatcher("/view/find/fine_find_manage_List.jsp");
					disp.forward(request, response);
				}
			}
		}
	


}
