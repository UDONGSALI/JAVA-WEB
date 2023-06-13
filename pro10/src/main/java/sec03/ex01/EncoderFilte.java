package sec03.ex01;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncoderFilte implements Filter {
	ServletContext context;
	
    public EncoderFilte() {
    }

	public void destroy() {
		System.out.println("destroy 호출");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");
		String context = ((HttpServletRequest)request).getContextPath();
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		String realPath = request.getServletContext().getRealPath(pathinfo);
		String mesg = " Context 정보:" + context + "\n URI 정보 : " + pathinfo + "\n 물리적 경로: " + realPath;
		System.out.println(mesg);
		
		
		long begin = System.currentTimeMillis();
		chain.doFilter(request, response);
		long end = System.currentTimeMillis();
		System.out.println("작업 시간" + (end-begin) + "ms");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("urf-8 인코딩.......");
		context = fConfig.getServletContext();
	}

}
