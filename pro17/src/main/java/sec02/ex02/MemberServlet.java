package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request, response);
	}

	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
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
	}
}

