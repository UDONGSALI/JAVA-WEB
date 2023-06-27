package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
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
			PrintWriter writer = response.getWriter();
			
			boolean nnot = true;// 이거
			
			String action = request.getPathInfo();
			System.out.println("action" + action);
			if (action == null || action.equals("/listMembers.do"))  {
				List<MemberVO> membersList = memberDAO.listMembers();
				request.setAttribute("membersList", membersList);
				nextPage = "/test03/listMembers.jsp";
			}else if(action.equals("/addMember.do")){
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				MemberVO memberVO = new MemberVO(id, pwd, name, email);
				memberDAO.addMember(memberVO);
				request.setAttribute("msg", "addMember");
				nextPage = "/member/listMembers.do";
			}else if(action.equals("/memberForm.do")){
				nextPage = "/test03/memberForm.jsp";
			} else if(action.equals("/modMemberForm.do")){
		    	 String id=request.getParameter("id");
		    	 MemberVO memInfo = memberDAO.findMember(id);  // DAO에서 새로 구현
		    	 request.setAttribute("memInfo", memInfo);
		    	 nextPage="/test03/modMemberForm.jsp";
			} else if(action.equals("/modMember.do")){
		         String id=request.getParameter("id");
		         String pwd=request.getParameter("pwd");
		         String name=request.getParameter("name");
		         String email=request.getParameter("email");
		         MemberVO memberVO= new MemberVO(id, pwd, name, email);
		         memberDAO.modMember(memberVO);
		         request.setAttribute("msg", "modified");
		         nextPage="/member/listMembers.do";
			}else if(action.equals("/delMember.do")){
				String id = request.getParameter("id");			
				memberDAO.delMember(id);
				request.setAttribute("msg", "deleted");
				nextPage = "/member/listMembers.do";				
			}
			else if(action.equals("/over.do")){
				String _id = (String) request.getParameter("_id");
				System.out.println(_id);
				MemberDAO memberDAO = new MemberDAO();
				boolean overlappedID = memberDAO.overlappedID(_id);
				System.out.println(overlappedID);
				if (overlappedID == true) {
					writer.print("not_usable");
				} else {
					writer.print("usable");
				}
				nnot = false;
			}else {
				List<MemberVO> membersList = memberDAO.listMembers();
				request.setAttribute("membersList ", membersList );
				nextPage = "/test03/listMembers.jsp";
			}
			if (nnot) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
				dispatcher.forward(request, response);
			}
		}
	}
