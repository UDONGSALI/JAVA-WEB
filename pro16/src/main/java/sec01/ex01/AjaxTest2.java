package sec01.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String result = "";
		PrintWriter writer = response.getWriter();
		result = "<main><book>" + 
				"<title><![CDATA[초보자를 위한 자바 프로그래밍]]></title>"+
				"<writer><![CDATA[인포북스 저 | 이병승]]></writer>"+
				"<image><![CDATA[http://localhost8090/pro16/image/image1.jpg]]></image>"+
				"</book>"+
				"<book>" + 
				"<title><![CDATA[모두의 파이썬]]></title>"+
				"<writer><![CDATA[길벗 저 | 이승찬]]></writer>"+
				"<image><![CDATA[http://localhost8090/pro16/image/image2.jpg]]></image>"+
				"</book></main>";
		System.out.println(result);
		writer.print(result);
	}
}

