package fine.rescue.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.rescue.service.RescueService;

@WebServlet("/rescueReply.do")
public class Rescue_Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Rescue_Reply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("sessionID") ==null) {
			PrintWriter out = response.getWriter();
			out.append("<script>alert('로그인 후 이용해 주세요')</script>");
			out.println("<script>history.back()</script>");
			out.flush();
			out.close();
		}else {
			String id = (String) request.getSession().getAttribute("sessionID");
			String rec_title = "댓글입니다.";
			String rec_content = request.getParameter("comments");
			String ref = request.getParameter("rec_no");
			String ref_step = request.getParameter("ref_step");
			if(ref_step == null) {
			ref_step = request.getParameter("ref_sub_step");
			}
			
			String ref_level = request.getParameter("ref_level");
			System.out.println("asdasdasdasasd"+ref_level);
			if(ref_level == null) {
				ref_level = request.getParameter("ref_sub_level");
				System.out.println("asdasdasdasasd"+ref_level);
			}
			
			RescueService adoptService = new RescueService();
			int result = adoptService.reply(id, rec_title, rec_content, ref, ref_step, ref_level);
			
			if (result == 1) {
				response.sendRedirect("./rescueDetail.do?rec_no="+ref);
			} else {
				System.out.println("Fail");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
