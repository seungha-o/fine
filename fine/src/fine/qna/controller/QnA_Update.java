package fine.qna.controller;

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

import fine.qna.service.QnAService;

@WebServlet("/qnaUpdate")
public class QnA_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QnA_Update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnAService qnaService = new QnAService();
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
		int qna_no = Integer.parseInt(mReq.getParameter("qna_no"));
		try {
			int result = qnaService.qnaUpdate(title, content, qna_no, saveFiles);
			if(result == 1) {
				response.sendRedirect("qnaList.do");
			} else {
				System.out.println(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
