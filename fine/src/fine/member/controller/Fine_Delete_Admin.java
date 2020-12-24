package fine.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.member.model.MembersService;


/**
 * Servlet implementation class Fine_Delete_Admin
 */
@WebServlet("/del.do")
public class Fine_Delete_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fine_Delete_Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		System.out.println(id);
		PrintWriter out = response.getWriter();
		String ctxPath = request.getContextPath();
		
		MembersService services = new MembersService();
		int result = services.adminDelete(id);
		if(result==1) {
			out.println("<script>alert('해당계정을 삭제하였습니다');</script>");
			out.println("<script>location.href='"+ctxPath+"/myPageList.do'</script>");
			}
	
	}

}
