package org.zerock.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.MemberMapper";
	
	@Override
	public int DueId(String m_id) {
		return sqlSession.selectOne(namespace+".DueId", m_id);
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace+".insertMember", vo);
	}

	@Override
	public void deleteMember(String m_id) {
		sqlSession.delete(namespace+".deleteMember", m_id);
	}

	@Override
	public MemberVO login(LoginDTO dto) {
		return sqlSession.selectOne(namespace+".login", dto);
	}



}
