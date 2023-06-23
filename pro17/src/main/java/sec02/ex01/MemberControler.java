package sec02.ex01;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberControler extends HttpServlet {
	MemberDAO memberDAO;
	
	public void init() throws ServletException{
		memberDAO = new MemberDAO();
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doHandle(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doHandle(request, response);
		}

		private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String nextPage = null;
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String action = request.getPathInfo();
			System.out.println("action" + action);
			if (action == null || action.equals("/listMembers.do"))  {
				List<MemberVO> membersList = memberDAO.listMembers();
				request.setAttribute("membersList", membersList);
				nextPage = "/test02/listMembers.jsp";
			}else if(action.equals("/addMember.do")){
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				MemberVO memberVO = new MemberVO(id, pwd, name, email);
				memberDAO.addMember(memberVO);
				nextPage = "/member/listMembers.do";
			}else if(action.equals("/memberForm.do")){
				nextPage = "/test02/memberForm.jsp";
			}else {
				List<MemberVO> membersList = memberDAO.listMembers();
				request.setAttribute("membersList ", membersList );
				nextPage = "/test02/listMembers.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		}
	}