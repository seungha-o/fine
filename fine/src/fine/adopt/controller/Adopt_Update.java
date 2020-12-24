package fine.adopt.controller;

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

import fine.adopt.service.AdoptService;

@WebServlet("/adoptUpdate")
public class Adopt_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Adopt_Update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdoptService qnaService = new AdoptService();
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
		int adopt_no = Integer.parseInt(mReq.getParameter("adopt_no"));
		try {
			int result = qnaService.adoptUpdate(title, content, adopt_no, saveFiles);
			if(result == 1) {
				response.sendRedirect("adoptList.do");
			} else {
				System.out.println(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
