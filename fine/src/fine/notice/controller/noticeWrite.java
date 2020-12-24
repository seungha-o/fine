package fine.notice.controller;

import java.io.IOException;
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

import fine.notice.model.NoticeVO;
import fine.notice.service.NoticeService;

/**
 * Servlet implementation class noticeWrite
 */
@WebServlet("/noticeWrite.do")
public class noticeWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public noticeWrite() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NoticeService nService = new NoticeService();
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
		}
		String title = mReq.getParameter("notice_title");
		String contents = mReq.getParameter("notice_contents");
		int pin = 0;
		if (mReq.getParameter("pin") != null){
		 pin = Integer.parseInt(mReq.getParameter("pin"));
		}

		NoticeVO vo = new NoticeVO();
		if (title != null && contents != null) {
			vo.setNotice_title(title);
			vo.setNotice_contents(contents);
			vo.setNotice_img(saveFiles);
			vo.setPin(pin);
			int result = nService.writeNotice(title, contents, saveFiles, pin);
		
			if (result < 0) {
				response.sendRedirect("<script>alert('오류가 발생했습니다.');</script>");
				return;
			}
		}
		response.sendRedirect("noticeList.do");
	}

}
