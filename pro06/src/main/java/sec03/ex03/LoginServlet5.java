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

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
    public LoginServlet5() {
    }
	public void init(ServletConfig config) throws ServletException {
	}
	public void destroy() {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("user_id");
		String upw = request.getParameter("user_pw");
		String uad = request.getParameter("user_address");
		System.out.println(uid);
		System.out.println(upw);
		
		String data = "<html>";
		data +="<body>";
		data +="아이디 : " +  uid;
		data +="<br>";
		data +="비밀번호 : " +  upw;
		data +="<br>";
		data +="주소 : " +  uad;
		data +="</body>";
		data +="</html>";
		out.print(data);
		
	}
}
