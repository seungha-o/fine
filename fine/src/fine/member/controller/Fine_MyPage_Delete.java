package fine.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.member.member.model.MembersService;



@WebServlet("/delete.do")
public class Fine_MyPage_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Fine_MyPage_Delete() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			execute(request,response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			try {
				execute(request,response);
			} catch (ServletException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("a1");
		String id = (String)request.getSession().getAttribute("sessionID"); //세션에담긴 아이디를 불러옵니다 id라고 이름지어주고
		String password = request.getParameter("pw");//페스워드를 가지고오는거구요
		System.out.println(id);
		System.out.println(password);
		PrintWriter out = response.getWriter();
		String ctxPath = request.getContextPath();
		
		MembersService services = new MembersService();//서비스
		int result = services.checkDeleteMember(id, password);	
		System.out.println("a3:" + result );
		if(result == 1) {
			int deleteResult = services.deleteMember(id);		
			System.out.println("delete ok : "+deleteResult);
			if(deleteResult == 1) {
				out.println("<script>alert('탈퇴를 완료했습니다.');</script>");
				out.println("<script>location.href='"+ctxPath+"/view/main/index.jsp'</script>");
				request.getSession().invalidate();//로그아웃해줌
			}else {
				out.println("<script>alert('탈퇴를 실패했습니다.');</script>");
				out.println("<script>location.href='"+ctxPath+"/view/main/index.jsp'</script>");
			}
		}else {
			System.out.println("a5:" + result );
			out.println("<script>alert('비밀번호를 다시 확인해주세요.');</script>");
			out.println("<script>location.href='"+ctxPath+"/view/member/myPage_pwCheck_delete.jsp'</script>");
		}
		
		
		out.flush();
		out.close();
	}
}
