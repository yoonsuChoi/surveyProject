package org.zerock.controller;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.MemberVO;
import org.zerock.domain.SurveyVO;
import org.zerock.service.SurveyService;

@Controller
@RequestMapping("/survey/*")
public class SurveyResultController {

	@Inject
	private SurveyService service;
	
	// 특정 설문 보기 가져오기 - 결과페이지
	@RequestMapping(value="/surveyResult", method=RequestMethod.GET)
	public void selectSurveyChoice(@RequestParam("sv_id") int sv_id, Model model) throws Exception{
		model.addAttribute("choices", service.selectSurveyChoices(sv_id));
	} 
}
