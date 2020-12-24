package fine.rescue.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import fine.rescue.service.RescueService;

@WebServlet("/rescueUpdate")
public class Rescue_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Rescue_Update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String title = mReq.getParameter("title");
		String content = mReq.getParameter("content");
		int rec_no = Integer.parseInt(mReq.getParameter("rec_no"));
		try {
			int result = qnaService.rescueUpdate(title, content, rec_no, saveFiles);
			if(result == 1) {
				response.sendRedirect("rescueList.do");
			} else {
				System.out.println(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
