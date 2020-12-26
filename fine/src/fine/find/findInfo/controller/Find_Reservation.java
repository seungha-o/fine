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
import fine.member.member.model.MemberVO;

/**
 * Servlet implementation class Find_Reservation
 */
@WebServlet("/ReservationForm.do")
public class Find_Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Find_Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<FindVO> list = new ArrayList<FindVO>();
		List<MemberVO> lists = new ArrayList<MemberVO>();
//		request.getSession().setAttribute("memberLev", lev);
//		request.getSession().setAttribute("sessionID", id);
		String ctx = request.getContextPath();
		
		if (request.getSession().getAttribute("sessionID") == null) {
			PrintWriter out = response.getWriter();
			out.append("<script>alert('로그인 후 이용해 주세요')</script>");
			out.println("<script>location.href='"+ctx+"/findHowMany.do'</script>");
		} else {
			FindService fService = new FindService();
			String id = (String) request.getSession().getAttribute("sessionID");
		
	
			int grade = fService.gerMemberGrade(id);

			if (grade >= 3) {
				lists = fService.getMembername(id);
			} else if (grade < 3) {

				PrintWriter out = response.getWriter();
				out.append("<script>alert('입양하기위한 등급이 낮습니다 훈련정보를 보고 퀴즈를 풀어주세요!')</script>");
				out.println("<script>history.back()</script>");
				out.flush();
				out.close();
			}
			int no = Integer.parseInt(request.getParameter("dogNum"));
			list = fService.getFindDetail(no);
			System.out.println(list);
			if (list == null) {
				System.out.println("예약서블릿의 리스트가 비어있습니다");
			} else
			request.setAttribute("lists", lists);
			request.setAttribute("list", list);
			RequestDispatcher disp = request.getRequestDispatcher("/view/find/find_reservation.jsp");
			disp.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
