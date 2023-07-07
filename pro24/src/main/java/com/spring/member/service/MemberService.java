package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberService {

	List listMembers() throws DataAccessException;

	int addMember(MemberVO memberVO) throws DataAccessException;

	int removeMember(String id) throws DataAccessException;
	
	MemberVO selectMemberById(String id) throws DataAccessException;
	
	int updateMember(MemberVO memberVO) throws DataAccessException;

}