package com.spring_boot.projectEx.dao;

import com.spring_boot.projectEx.model.MemberVO;

public interface IMemberDAO {
	public String loginCheck(String id);
	public void insertMember(MemberVO vo);
}
