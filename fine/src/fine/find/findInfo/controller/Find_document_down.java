package fine.find.findInfo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * Servlet implementation class Find_document_down
 */
@WebServlet("/documentDown.do")
public class Find_document_down extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find_document_down() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//게시글 첨부파일 다운 처리용 컨트롤러
		
		request.setCharacterEncoding("utf-8");
		//프로젝트 내에 파일이 저장된 폴더의 경로정보 얻어옴
		String readFolder = request.getSession().getServletContext().getRealPath("/upload/adoptfile");
		String oolean = request.getParameter("file");
		System.out.println(oolean);
		ServletOutputStream downOut =
				response.getOutputStream();
				File downFile = new File(readFolder + "/" + oolean);
				response.setContentType("text/plain; charset=utf-8");
				String originalFileName = "findDoc.hwp";
				
				
				//한글 파일명 인코딩 처리함
				response.addHeader("Content-Disposition",
				"attachment; filename=\"" +
				new String(originalFileName .getBytes("UTF-8"),"ISO-8859-1") + "\"");
				response.setContentLength((int)downFile.length());
				BufferedInputStream bin = new BufferedInputStream(
				new FileInputStream(downFile));
				int read = -1;
				while((read = bin.read()) != -1){
				downOut.write(read);
				downOut.flush();
				}
				downOut.close();
				bin.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
