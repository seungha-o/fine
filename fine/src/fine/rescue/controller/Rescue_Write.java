package fine.rescue.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import fine.rescue.model.RescueVO;
import fine.rescue.service.RescueService;

@WebServlet("/rescueWrite.do")
public class Rescue_Write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Rescue_Write() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RescueService qnaService = new RescueService();
		String folderPath = getServletContext().getRealPath("/files");
		MultipartRequest mReq = new MultipartRequest(request, folderPath, 5 * 1024 * 1024, "utf-8",
				new DefaultFileRenamePolicy());

		List<String> saveFiles = new ArrayList<String>();
		List<String> originFiles = new ArrayList<String>();
		Enumeration<String> files = mReq.getFileNames();

		while (files.hasMoreElements()) {
			String name = files.nextElement();
			String filename = mReq.getFilesystemName(name);
			String originfilename = mReq.getOriginalFileName(name);
			saveFiles.add(filename);
			originFiles.add(originfilename);
			System.out.println(name);
			System.out.println(filename);
			System.out.println(originfilename);
			if(filename == null) 
				System.out.println("업로드 실패");
		}
		
		String id = mReq.getParameter("id");
		String title = mReq.getParameter("title");
		String content = mReq.getParameter("content");
		try {
			if (title != null && content != null) {
				RescueVO vo = new RescueVO();
				vo.setId(id);
				vo.setRec_title(title);
				vo.setRec_contents(content);
				vo.setRec_img(saveFiles);
				int result = qnaService.rescueWrite(id, title, content, saveFiles);
				if (result < 0) {
					response.sendRedirect("<script>alert('오류가 발생했습니다.');</script>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher disp = request.getRequestDispatcher("rescueList.do");
		disp.forward(request, response);
//		response.sendRedirect("./qnaList.do");
// login/sign 오른쪽, drop, 이미지 자동 넘김, 레이아웃, media
	}
	
}
