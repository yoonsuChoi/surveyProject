package org.zerock.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.MemberDAO;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;

	@Override
	public int DueId(String m_id) throws Exception {
		return dao.DueId(m_id);
	}

	@Override
	public void insertMember(MemberVO vo) throws Exception {
		dao.insertMember(vo);
	}

	@Override
	public void deleteMember(String m_id) throws Exception {
		dao.deleteMember(m_id);
	}

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}


	


}
