package sec04.ex01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

//@WebServlet("/login")
public class LoginImpl implements HttpSessionBindingListener {
	String user_id;
	String user_pw;
	static int total_user = 0;
	
    public LoginImpl() {
    }
    
    public LoginImpl(String user_id, String user_pw) {
    	this.user_id = user_id;
    	this.user_pw = user_pw;
    }
    
    @Override
    public void valueBound(HttpSessionBindingEvent arg0) {
    	System.out.println("사용자 접속");
    	++total_user;
    }
    
    @Override
    public void valueUnbound(HttpSessionBindingEvent arg0) {
    	System.out.println("사용자 접속 해제");
    	total_user--;
    }

}
