package com.spring.ex03;

public class MemberServiceImpl implements MemberDAO{
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	@Override
	public void listMembers() {
		memberDAO.listMembers();	
	}
}
