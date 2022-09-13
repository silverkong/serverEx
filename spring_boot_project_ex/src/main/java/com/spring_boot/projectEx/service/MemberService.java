package com.spring_boot.projectEx.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dao.IMemberDAO;
import com.spring_boot.projectEx.model.MemberVO;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
	@Qualifier("IMemberDAO")
	IMemberDAO dao;
	
	@Autowired
	PasswordEncoder pwdEncoder;

//	@Override
//	public String loginCheck(HashMap<String, Object> map) {
//		return dao.loginCheck(map);
//	}
	
	// 암호화 로그인 체크
	@Override
	public String loginCheck(HashMap<String, Object> map) {
		// 전달 받은 아이디로 암호화된 비밀번호 알아온 후
		String encodedPwd = dao.loginCheck((String)map.get("id"));
		
		// 입력한 비밀번호 평문과 mapper에서 받은 암호화된 비밀번호가 일치하는 지 체크
		String result = "fail";
		if(encodedPwd != null && pwdEncoder.matches((String)map.get("pwd"), encodedPwd)) {
			result = "success";
		}
		
		return result;
	}

	@Override
	public void insertMember(MemberVO vo) {
		// 비밀번호 암호화 처리한 후 mapper에게 전달
		String encodedPwd = pwdEncoder.encode(vo.getMemPwd());
		vo.setMemPwd(encodedPwd);
		
		dao.insertMember(vo);
	}

}
