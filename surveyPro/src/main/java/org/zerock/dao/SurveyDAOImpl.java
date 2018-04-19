package org.zerock.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.SurveyVO;

@Repository
public class SurveyDAOImpl implements SurveyDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.SurveyMapper";
	
	@Override
	public List<SurveyVO> selectAllSurvey() {
		return sqlSession.selectList(namespace+".selectAllSurvey");
	}

	@Override
	public void insertSurvey(SurveyVO vo) {
		sqlSession.insert(namespace+".insertSurvey", vo);
	}

	@Override
	public void deleteSurvey(int sv_id) {
		sqlSession.delete(namespace+".deleteSurvey", sv_id);
	}

	@Override
	public void updateSurvey(SurveyVO vo) {
		sqlSession.update(namespace+".updateSurvey", vo);
	}

	@Override
	public List<SurveyVO> selectMySurvey(String m_id) {
		return sqlSession.selectList(namespace+".selectMySurvey", m_id);
	}

	@Override
	public List<SurveyVO> selectSurvey(int sv_id) {
		return sqlSession.selectList(namespace+".selectSurvey",sv_id);
	}

	@Override
	public String selectTitle(int sv_id) {	
		return sqlSession.selectOne(namespace+".selectTitle", sv_id);
	}

	@Override
	public List<SurveyVO> insertResult(String m_id, int list_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("m_id", m_id);
		map.put("list_id",list_id);
		return sqlSession.selectList(namespace+".insertResult",map);
	}

	@Override
	public void updateChunum(int list_id) {
		sqlSession.update((namespace)+".updateChunum",list_id);
		
	}

	@Override
	public List<SurveyVO> resultCheck(String m_id, int sv_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("m_id", m_id);
		map.put("sv_id",sv_id);
		
		return sqlSession.selectList(namespace+".resultCheck",map);
	}


}
