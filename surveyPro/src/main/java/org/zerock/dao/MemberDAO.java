package org.zerock.dao;

import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

public interface MemberDAO {

	public int DueId(String m_id);
	public void insertMember(MemberVO vo);
	public void deleteMember(String m_id);
	public MemberVO login(LoginDTO dto);
	
	
}
