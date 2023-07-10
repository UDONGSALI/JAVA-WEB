package com.spring.ex02;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
@RequestMapping("/test")
public class LoginController {
   @RequestMapping(value="/loginForm.do" ,method={RequestMethod.GET, RequestMethod.POST})
   public ModelAndView loginController(HttpServletRequest request, HttpServletResponse response)  throws Exception{
      ModelAndView mav=new ModelAndView();
      mav.setViewName("loginForm");
      return mav;
   }

   @RequestMapping(value="/login2.do" ,method= {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView login2(@RequestParam(value = "userID", required = true) String userID,
		   @RequestParam(value = "userName", required = false) String userName,
		   @RequestParam(value = "email", required = false) String email)  throws Exception{
	  ModelAndView mav=new ModelAndView();
      mav.setViewName("result");
      System.out.println(userID);
      System.out.println(userName);
      System.out.println(email);
      mav.addObject("userID",userID);
      mav.addObject("userName",userName);
      mav.addObject("email",email);
      return mav;
   }

   @RequestMapping(value="/login3.do" ,method= {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView login3(@RequestParam Map<String,String> info) throws Exception{
	  ModelAndView mav=new ModelAndView();
      String userID  = info.get("userID");
      String userName  = info.get("userName");
      System.out.println(userID);
      System.out.println(userName);
      mav.addObject("info", info);
      mav.setViewName("result");
      return mav;
      //확인
   }

   @RequestMapping(value="/login4.do" ,method= {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView login4(@ModelAttribute("info") LoginVO loginVO) throws Exception{
	  ModelAndView mav=new ModelAndView();
      System.out.println("userID : " + loginVO.getUserID());
      System.out.println("userName : " + loginVO.getUserName());
      mav.setViewName("result");
      return mav;
   }
}