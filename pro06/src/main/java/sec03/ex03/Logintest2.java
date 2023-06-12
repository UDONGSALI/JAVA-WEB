package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logintest2")
public class Logintest2 extends HttpServlet {
    public Logintest2() {
    }
	public void init(ServletConfig config) throws ServletException {
	}
	public void destroy() {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		System.out.println(id);
		System.out.println(pw);
		
		if(id!= null && (id.length()!=0)) {
			if(id.equals("admin")){
					out.print("<html>");
					out.print("<body>");
					out.print("<font size ='12'>관리자로 로그인 하셨습니다!</font>");
					out.print("</body>");
					out.print("</html>");
					}else {
						out.print("<html>");
						out.print("<body>");
						out.print(id  + "님 로그인 하셨습니다!");
						out.print("</body>");
						out.print("</html>");
					}
		}else {
			out.print("<html>");
			out.print("<body>");
			out.print("아이디와 비밀번호를 입력하세요!");
			out.print("<br>");
			out.print("<a href ='http://localhost:8090/pro06/test01/login.html'> 로그인 창으로 이동 </a>");
			out.print("</body>");
			out.print("</html>");
		}
	}

}
