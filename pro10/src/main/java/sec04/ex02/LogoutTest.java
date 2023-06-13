package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	ServletContext context;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context = getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");// List에서 삭제할 user_id 가져옴
		System.out.println("삭제할 아이디" + user_id);
		session.invalidate();
		List user_list = (ArrayList) context.getAttribute("user_list"); // ServletContext 에서user_list 가져옴
		System.out.println("삭제 전 리스트 " + user_list);
		user_list.remove(user_id); // List 에 저장된user_id 제거
		context.removeAttribute("user_list"); // ServletContext 에서user_list 제거
		System.out.println("삭제 후 리스트 " + user_list);
		context.setAttribute("user_list", user_list); // 다시 user_id가 제거된user_list 를 ServletContext 를 저장
		out.println("<a href='login.html'>다시 로그인 하기</a>");
		out.println("<br>로그아웃 했습니다.");
		

	}
}
