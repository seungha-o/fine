package fine.qna.controller;

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

import fine.qna.model.QnAVO;
import fine.qna.service.QnAService;

@WebServlet("/qnaWrite.do")
public class QnA_Write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QnA_Write() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		
		String id = mReq.getParameter("id");
		String title = mReq.getParameter("title");
		String content = mReq.getParameter("content");
		String pass = mReq.getParameter("pass");
		try {
			if (title != null && content != null) {
				QnAVO vo = new QnAVO();
				vo.setId(id);
				vo.setQna_title(title);
				vo.setQna_contents(content);
				vo.setQna_pass(pass);
				vo.setQna_img(saveFiles);
				int result = qnaService.qnaWrite(id, title, content, pass, saveFiles);
				if (result < 0) {
					response.sendRedirect("<script>alert('오류가 발생했습니다.');</script>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher disp = request.getRequestDispatcher("qnaList.do");
		disp.forward(request, response);
//		response.sendRedirect("./qnaList.do");
// login/sign 오른쪽, drop, 이미지 자동 넘김, 레이아웃, media
	}
	
}
