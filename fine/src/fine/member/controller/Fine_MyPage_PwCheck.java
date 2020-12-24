package fine.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.member.model.MembersService;




@WebServlet("/PwCheck.do")
public class Fine_MyPage_PwCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Fine_MyPage_PwCheck() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		execute(request, response);
	}
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = (String)request.getSession().getAttribute("sessionID");
		String password = request.getParameter("pw");
		System.out.println(id);
		System.out.println(password);
		System.out.println("a0");
		
		PrintWriter out = response.getWriter();
		String ctxPath = request.getContextPath();
		
		MembersService services = new MembersService();
		int result = services.PwCheck(id ,password);
		System.out.println("a1");
			if (result == 1) { 
				System.out.println("a2");
				request.getSession().setAttribute("sessionID", id);
				request.setAttribute("result", result);
				out.println("<script>alert('비밀번호  확인되었습니다');</script>");
				out.println("<script>location.href='"+ctxPath+"/Update.do'</script>");  //어디로 이동하지 ?
//				out.println("<script>location.href='./index.jsp'</script>");         //어디로 이동하지 ?
			}else if (result == 0){		
				System.out.println("a3");
				out.println("<script>alert('비밀번호를 다시 확인해주세요.');</script>");
				out.println("<script>location.href='"+ctxPath+"/member/pwCheck.jsp'</script>");				
			} 		
			System.out.println("a4");
			out.flush();
			out.close();

	}
}
