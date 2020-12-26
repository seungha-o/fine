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

import fine.find.findInfo.model.ReserVO;
import fine.find.findInfo.service.FindService;

/**
 * Servlet implementation class fine_manage_reservationChck
 */
@WebServlet("/reservationChck.do")
public class fine_manage_reservationChck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fine_manage_reservationChck() {
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
		if(!request.getSession().getAttribute("memberLev").equals("2")) {
			PrintWriter out = response.getWriter();
			out.append("<script>alert('정상적인 접근이 아닙니다.')</script>");
			out.println("<script>location.href='"+ctx+"/findHowMany.do'</script>"); 
			out.flush();
			out.close();
		}else {
			List<ReserVO> list = new ArrayList<ReserVO>();
			FindService fService = new FindService();
			list = fService.getReservationInfo(id);
			if(list == null) {
				PrintWriter out = response.getWriter();
				out.append("<script>alert('예약정보가 없습니다')</script>");
				out.println("<script>location.href='"+ctx+"/findHowMany.do'</script>"); 
				out.flush();
				out.close();
			}else {
				request.setAttribute("list", list);
				RequestDispatcher disp = request.getRequestDispatcher("./view/find/fine_find_reservation_list.jsp");
						
				disp.forward(request, response);
				
			}
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
