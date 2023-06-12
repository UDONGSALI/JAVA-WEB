package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.DocFlavor.STRING;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static float USD_RATE = 1310f;
	private static float JYP_RATE = 10.31f;
	private static float CNY_RATE = 166.31f;
	private static float GBP_RATE = 1444.31f;
	private static float EUR_RATE = 1300.31f;
	
    public CalcServlet() {
    }
	public void init(ServletConfig config) throws ServletException {
	}
	public void destroy() {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		if (command != null && command.equals("calcurate")) {
			String result = calcurate(Float.parseFloat(won), operator);
			pw.print("<html><font size=10>변환결과</font><br>");
			pw.print("<html><font size=10>" + result + "</font><br>");
			pw.print("<a href='/pro06/calc'>환율 계산기</a>");
			return;
		}
		
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form name='frmCalc' method='get' action='/pro06/calc' />");
		pw.print("원화 : <input type = 'text' name= 'won' size=10 />");
		pw.print("<select name = 'operator'>");
		pw.print("<option value = 'dollor'>달러</option>");
		pw.print("<option value = 'en'>엔</option>");
		pw.print("<option value = 'wian'>위안</option>");
		pw.print("<option value = 'pound'>파운드</option>");
		pw.print("<option value = 'euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type = 'hidden' name= 'command' value='calcurate' />");
		pw.print("<input type = 'submit' value='변환' />");
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
		
	}
	private static String calcurate(float won, String operator) {
		String result = null;
		if(operator.equals("dollor")) {
			result = String.format("%.6f", won / USD_RATE);
		}else if(operator.equals("en")) {
			result = String.format("%.6f", won / JYP_RATE);
		}else if(operator.equals("wian")) {
			result = String.format("%.6f", won / CNY_RATE);
		}else if(operator.equals("pound")) {
			result = String.format("%.6f", won/  GBP_RATE);
		}else if(operator.equals("euro")) {
			result = String.format("%.6f", won / EUR_RATE);
		}
		return result;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
