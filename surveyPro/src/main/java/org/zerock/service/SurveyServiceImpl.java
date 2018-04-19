package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.dao.SurveyDAO;
import org.zerock.domain.SurveyVO;

@Service
public class SurveyServiceImpl implements SurveyService {

	@Inject
	private SurveyDAO dao;
	
	@Override
	public List<SurveyVO> selectAllSurvey() throws Exception {
		return dao.selectAllSurvey();
	}

	@Override
	public void insertSurvey(SurveyVO vo) throws Exception {
		dao.insertSurvey(vo);
	}

	@Override
	public void deleteSurvey(int sv_id) throws Exception {
		dao.deleteSurvey(sv_id);
	}

	@Override
	public void updateSurvey(SurveyVO vo) throws Exception {
		dao.updateSurvey(vo);
	}

	@Override
	public List<SurveyVO> selectMySurvey(String m_id) throws Exception {
		return dao.selectMySurvey(m_id);
	}

	@Override
	public List<SurveyVO> selectSurvey(int sv_id) throws Exception {
		return dao.selectSurvey(sv_id);
	}

	@Override
	public String selectTitle(int sv_id) throws Exception {	
		return dao.selectTitle(sv_id);
	}

	@Override
	public List<SurveyVO> insertResult(String m_id, int list_id) throws Exception {
		return dao.insertResult(m_id, list_id);
	}

	@Override
	public void updateChunum(int list_id) throws Exception {
		dao.updateChunum(list_id);
		
	}

}
