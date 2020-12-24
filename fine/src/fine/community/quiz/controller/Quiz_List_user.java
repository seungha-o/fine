package fine.community.quiz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fine.community.quiz.model.QuizVO;
import fine.community.quiz.service.QuizService;

@WebServlet("/quiz_List_user.do")
public class Quiz_List_user extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Quiz_List_user() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		execute(request, response);
	}

	protected void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		int count = -1; // 0번째 배열을 뽑아내기 위한 선언
		
		if (session.getAttribute("count") == null) {
			System.out.println("a1");
			QuizService qservice = new QuizService();
			List<QuizVO> storeList2 = qservice.randomQuizList();
			session.setAttribute("quizlist", storeList2);
			session.setAttribute("count", 0);
			count = 0;
			System.out.println("a1: "+ storeList2.size());
		} else {
			List<QuizVO> quizlist = (List<QuizVO>) session.getAttribute("quizlist");

			if(session.getAttribute("count") == null) {  // 첫진입
				System.out.println("a2");
				session.setAttribute("count", 0);
				count= 0;
			} else {
				count = (int)session.getAttribute("count");
				System.out.println("a3 : "+ count);
				if (count < 0 || count > 10) { // 문항 설정에 문제 발생한다면
					session.setAttribute("count", 0);
					count= 0;
				}
			} 
			
			String qans = "0";
			if(request.getParameter("q_answer") == null) {
				// 답변 하지 않은 상황인지, 원치 않는 경로로 진입한 상황인지 판단필요. // 그에 따른 예외처리필요.
				session.setAttribute("count", 0);
				System.out.println("a4 : "+ qans);
			} else {
				qans = request.getParameter("q_answer");
				System.out.println("a5 : "+ qans);
			}
			String cnt = "0";
			if(request.getParameter("cnt") == null) {
				System.out.println("a6 : "+ cnt);
			} else {
				cnt = request.getParameter("cnt");
				System.out.println("a7 : "+ cnt);
			}
			if(quizlist==null) System.out.println("a8 null");
			if(quizlist.get(0)==null) System.out.println("a8 null0");
			if(quizlist.get(count)==null) System.out.println("a8 nullaa");
			if(quizlist.get(count).getAnswer()==null) System.out.println("a8 nullvv");
			
			System.out.println("a888 : "+ quizlist.get(count).getAnswer() + " : " + qans);
			if (quizlist.get(count).getAnswer().equals(qans)) {// 조건에 맞는경우
				quizlist.get(count).setUser_answer("Y");
				System.out.println("a8 : "+ quizlist.get(count).getUser_answer());
			} else { // 틀린경우
				quizlist.get(count).setUser_answer("N");
				System.out.println("a9 : "+ quizlist.get(count).getUser_answer());
			}

			if (cnt.equals("-1")) {
				System.out.println("a10 : " + count);
				count = count - 1;
				session.setAttribute("count", count);
			} else {
				System.out.println("a11 : " + count);
				count = count + 1;
				session.setAttribute("count", count);
			}
			
			if(count==10) {
				System.out.println("a12 : " + count);
				int totalResult = 0;
				for(QuizVO e:quizlist) {
					if(e.getUser_answer().equals("Y")) {
						System.out.println("a13 : " + totalResult);
						totalResult += 10;
					}
				}
				
				String grade = "";
				int gradeNO = 0;
				int result = totalResult/10;
				if(result >= 9){
					grade = "다이아";
					gradeNO = 4;
				}else if(result >= 7){
					grade = "플레티넘";
					gradeNO = 3;
				}else if(result >= 5){
					grade = "골드";
					gradeNO = 2;
				}else if(result >= 3){
					grade = "실버";
					gradeNO = 1;
				}else{
					grade = "브론즈";
					gradeNO = 0;
				}
				
				System.out.println("grade :"+grade);
				System.out.println("gradeNO : "+gradeNO);
				System.out.println(totalResult);
				QuizService qservice = new QuizService();
				String id = (String) request.getSession().getAttribute("sessionID");  //추후에 세션아이디로 변경하셔야합니다   (String)request.getSession().getAttribute("id");
				int resultUp = qservice.updateGrade(gradeNO,id);
				System.out.println("a14 : " + totalResult);
				session.removeAttribute("count");
				session.removeAttribute("quizlist");
				request.setAttribute("grade", grade);
				request.setAttribute("totalResult", totalResult);
				request.getRequestDispatcher("./view/quiz/fine_quiz_result.jsp").forward(request, response);
			}
		}
		System.out.println("a15 : " + count);
		request.getRequestDispatcher("./view/quiz/fine_quiz.jsp").forward(request, response);

	}
}