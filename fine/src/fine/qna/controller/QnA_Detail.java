package fine.qna.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fine.qna.model.QnAVO;
import fine.qna.service.QnAService;

@WebServlet("/qnaDetail.do")
public class QnA_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QnA_Detail() {
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

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			QnAService qnaService = new QnAService();
			String id = (String) request.getSession().getAttribute("sessionID");
			String level = (String) request.getSession().getAttribute("memberLev");
			int strQna_no = Integer.parseInt(request.getParameter("qna_no"));
			QnAVO vo = qnaService.qnaDetail(strQna_no);
			List<QnAVO> list = new ArrayList<QnAVO>();
			list = qnaService.getComent(strQna_no);
			System.out.println(list);
			String member_id = vo.getId();
			System.out.println("상세글보기!!!"+vo);
//			int ref_step = vo.getRef_step();
//			int ref_level = vo.getRef_level();
			if (vo != null) {
				request.setAttribute("list", list);
				request.setAttribute("id", id);
				request.setAttribute("member_id", member_id);
				request.setAttribute("level", level);
				request.setAttribute("detailList", vo);
				RequestDispatcher disp = request.getRequestDispatcher("./view/qna/QnADetail.jsp");
				disp.forward(request, response);
//					} else {
//						
//					}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
