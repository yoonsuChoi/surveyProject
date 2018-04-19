package org.zerock.service;

import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

public interface MemberService {
	
	// 아이디 중복체크
	public int DueId(String m_id) throws Exception;
	// 회원가입
	public void insertMember(MemberVO vo) throws Exception; 
	// 회원탈퇴
	public void deleteMember(String m_id) throws Exception;
	// 로그인
	public MemberVO login(LoginDTO dto) throws Exception;
	
}
