package org.zerock.service;

import java.util.List;

import org.zerock.domain.SurveyVO;

public interface SurveyService {
	
	public List<SurveyVO> selectMySurvey(String m_id) throws Exception;
	public List<SurveyVO> selectAllSurvey() throws Exception;
	public List<SurveyVO> selectSurvey(int sv_id) throws Exception;	
	public String selectTitle(int sv_id) throws Exception;  
	public void insertSurvey(SurveyVO vo) throws Exception;
	public void deleteSurvey(int sv_id) throws Exception;
	public void updateSurvey(SurveyVO vo) throws Exception;
	public List<SurveyVO> insertResult(String m_id, int list_id) throws Exception;
	public void updateChunum(int list_id) throws Exception;
	public List<SurveyVO> selectSurveyChoices(int sv_id) throws Exception;
}
