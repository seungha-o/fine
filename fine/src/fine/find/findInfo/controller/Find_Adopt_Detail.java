package fine.find.findInfo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.find.findInfo.model.FindVO;
import fine.find.findInfo.service.FindService;

/**
 * Servlet implementation class Find_Detail
 */
@WebServlet("/findAdoptDetail.do")
public class Find_Adopt_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find_Adopt_Detail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String ctx = request.getContextPath();
		String id = (String) request.getSession().getAttribute("sessionID");
		System.out.println(id);
		if(request.getSession().getAttribute("sessionID") == null) {
			PrintWriter out = response.getWriter();
			out.append("<script>alert('로그인 후 이용해 주세요')</script>");
			out.println("<script>location.href='"+ctx+"/findHowMany.do'</script>"); 
		}else {
			FindService fService = new FindService(); 
			
			int no = Integer.parseInt(request.getParameter("no"));
			List<FindVO> list = new ArrayList<FindVO>();
			list = fService.getFindDetail(no); 
			System.out.println(list);
			request.setAttribute("list", list);
			//response.sendRedirect("../training/fine_training_Dtail.jsp?trn_no="+no);
			RequestDispatcher disp = request.getRequestDispatcher("/view/find/fine_find_Adopt_Detail.jsp");
			disp.forward(request, response);	
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
