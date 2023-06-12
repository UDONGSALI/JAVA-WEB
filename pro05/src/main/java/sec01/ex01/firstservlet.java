package sec01.ex01;

import java.io.IOException;
import java.rmi.ServerException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class firstservlet extends HttpServlet{

	public void init() throws ServletException{
		System.out.println("init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException{
		System.out.println("doGet 메서드 호출");
	}
	
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
