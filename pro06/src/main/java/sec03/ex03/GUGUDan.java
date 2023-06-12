package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.imageio.metadata.IIOMetadataFormatImpl;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ggd")
public class GUGUDan extends HttpServlet {
    public GUGUDan() {
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
		
		int dan = Integer.parseInt(request.getParameter("dan"));
		out.print("<table border=1 width =800 align=center>");
		out.print("<tr align=center bgcolor='#ffff66'>");
		out.print("<td colspan=2>" + dan + " 단 출력 </td>");
		out.print("</tr>");
		
		for (int i = 1; i < 10; i++) {
			if(i % 2 == 0) {
				out.print("<tr ailgn = center bgcolor='#ACFA58'>");
			}else {
				out.print("<tr ailgn = center bgcolor='#81BEF7'>");
			}
			out.print("<td  width=200>");
			out.print("<input type='radio' />" + i);
			out.print("</td>");
			out.print("<td width=200>");
			out.print("<input type='checkbox' />" + i);
			out.print("</td>");
			out.print("<td width=400>");
			out.print(dan + " * " + i);
			out.print("<td width=400>");
			out.print(i * dan);
			out.print("</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
	}

}
