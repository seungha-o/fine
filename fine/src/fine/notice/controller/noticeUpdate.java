package fine.notice.controller;

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

import fine.notice.service.NoticeService;

/**
 * Servlet implementation class noticeUpdate
 */
@WebServlet("/noticeUpdate.do")
public class noticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String content = mReq.getParameter("notice_contents");
		int no = Integer.parseInt(mReq.getParameter("notice_no"));
		try {
			int result = nService.UpdateNotice(title, content, no, saveFiles);
			if(result == 1) {
				response.sendRedirect("noticeList.do");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
