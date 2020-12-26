package fine.find.findInfo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import fine.find.findInfo.service.FindService;

/**
 * Servlet implementation class Find_Reservation_Adopt
 */
@WebServlet("/Reservation.do")
public class Find_Reservation_Adopt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find_Reservation_Adopt() {
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
		System.out.println("aaaaaaadadjjaaaaaaaa"+id);
		if(request.getSession().getAttribute("sessionID") == null) {
				PrintWriter out = response.getWriter();
				out.append("<script>alert('로그인 후 이용해 주세요')</script>");
				out.println("<script>location.href='"+ctx+"/findHowMany.do'</script>"); 
				out.flush();
				out.close();
			
		}else {
				FindService fService = new FindService();
				int grade = fService.gerMemberGrade(id);
				if (grade >= 3) {
					int dogNum = Integer.parseInt(request.getParameter("dogNum"));
					String careNm = request.getParameter("careName"); //보호소 번호 가져와야함
					System.out.println(careNm);
					String careNoResult = fService.getCareNo(careNm); 
					System.out.println("케[어넘언ㅁ어멍"+careNoResult);
					String adoptDate = request.getParameter("date");
					SimpleDateFormat format1 = new SimpleDateFormat ("yyyyMMdd");
					Calendar time = Calendar.getInstance();					       
					String today = format1.format(time.getTime());
					
				
					if(adoptDate.equals("")) {
						PrintWriter out = response.getWriter();
						out.append("<script>alert('날짜를 선택해 주세요')</script>");
						out.println("<script>history.back()</script>");
						out.flush();
						out.close();
					}else {
						if(Integer.parseInt(adoptDate) < Integer.parseInt(today)) {
							PrintWriter out = response.getWriter();
							out.append("<script>alert('오늘날짜 이후를 선택해주세요')</script>");
							out.println("<script>history.back()</script>");
							out.flush();
							out.close();
						}
					}
					String[] chk = request.getParameterValues("agree");
					if(chk == null) {
						PrintWriter out = response.getWriter();
						out.append("<script>alert('약관에 동의해 주세요')</script>");
						out.println("<script>history.back()</script>");
						out.flush();
						out.close();
					}else {
						if(chk.length != 2) {
							PrintWriter out = response.getWriter();
							out.append("<script>alert('약관에 동의해 주세요')</script>");
							out.println("<script>history.back()</script>");
						}else if(chk.length == 2){
							int result = fService.insertReservatoin(careNoResult,adoptDate,dogNum,id);
							if(result == 1) {
								int update = fService.updateDog(dogNum);
								if(update == 1) {
									response.sendRedirect("./view/find/find_reservation_done.jsp");									
								}else {
									PrintWriter out = response.getWriter();
									out.append("<script>alert('이미 누가 예약을 끝냈습니다. 다른 유기견도 기다리고 있습니다!')</script>");
									out.println("<script>'"+ctx+"/findHowMany.do'</script>");
									out.flush();
									out.close();
								}
								
							}else {
								PrintWriter out = response.getWriter();
								out.append("<script>alert('죄송합니다 입양예약에 실패하였습니다! 다시 시도해 주세요')</script>");
								out.println("<script>'"+ctx+"/findHowMany.do'</script>");
								out.flush();
								out.close();
							}
							
						}	
					}
					
					//db저장
				}else {
					PrintWriter out = response.getWriter();
					out.append("<script>alert('부적절한 등급입니다.')</script>");
					out.println("<script>location.href='./view/main/index.jsp'</script>");
					out.flush();
					out.close();
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
