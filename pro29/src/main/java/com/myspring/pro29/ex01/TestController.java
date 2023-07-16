package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/*")
public class TestController {
	 static org.slf4j.Logger logger = LoggerFactory.getLogger(TestController.class);
	@RequestMapping("/hello")
	public String hello() {
		return "Hello REST!!";
	}
	
	@RequestMapping("/member")
	public MemberVO memberVO() {
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setPwd("1234");
		vo.setName("È«±æµ¿");
		vo.setEmail("hong@naver.com");
		return vo;
	}
	
	@RequestMapping("/membersList")
	public List<MemberVO> listMembers (){
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong" + i);
			vo.setPwd("1234" + i);
			vo.setName("È«±æµ¿" + i);
			vo.setEmail("hong" +i+"@naver.com" );
			list.add(vo);
		}
		return list;
	}
	
	@RequestMapping("/membersMap")
	public Map<Integer, MemberVO> membersMap(){
		Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
		for (int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong" + i);
			vo.setPwd("1234" + i);
			vo.setName("È«±æµ¿" + i);
			vo.setEmail("hong" +i+"@naver.com" );
			map.put(i, vo);
		}
		return map;
	}
	
	@RequestMapping(value = "/notice/{num}", method = RequestMethod.GET)
	public int notice(@PathVariable("num") int num)throws Exception{
		Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
		return num;
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.POST)
	public void modifye(@RequestBody MemberVO vo){
		logger.info(vo.toString());
	}
	
	@RequestMapping("/membersList2")
	public ResponseEntity<List<MemberVO>> listMembers2 (){
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong" + i);
			vo.setPwd("1234" + i);
			vo.setName("È«±æµ¿" + i);
			vo.setEmail("hong" +i+"@naver.com" );
			list.add(vo);
		}
		return new ResponseEntity(list, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(value = "/res3")
	public ResponseEntity res3(){
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		String messge = "<script>";
		messge += "alert('»õ È¸¿øÀ» µî·ÏÇÕ´Ï´Ù.);";
		messge += "location.href='/pro29/test/membersList2'; ";
		messge += "</script>";
		return new ResponseEntity(messge, responseHeaders, HttpStatus.CREATED);
		}
}