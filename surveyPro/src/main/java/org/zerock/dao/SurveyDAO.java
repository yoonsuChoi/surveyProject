package org.zerock.dao;

import java.util.HashMap;
import java.util.List;

import org.zerock.domain.SurveyVO;

public interface SurveyDAO {

	public List<SurveyVO> selectAllSurvey();
	public List<SurveyVO> selectMySurvey(String m_id);
	public List<SurveyVO> selectSurvey(int sv_id);
	public String selectTitle(int sv_id);  
	public void insertSurvey(SurveyVO vo);
	public void deleteSurvey(int sv_id);
	public void updateSurvey(SurveyVO vo);
	
	
	public List<SurveyVO> insertResult(String m_id, int list_id);
	public void updateChunum(int list_id);
	public List<SurveyVO> resultCheck(String m_id, int sv_id);
	
	public List<SurveyVO> selectSurveyChoices(int sv_id);
	
	
}
