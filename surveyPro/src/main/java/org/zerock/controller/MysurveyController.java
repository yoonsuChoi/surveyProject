package org.zerock.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.MemberVO;
import org.zerock.service.SurveyService;

@Controller
@RequestMapping("/mysurvey/*")
public class MysurveyController {
	
	@Inject
	private SurveyService service;
	
	@RequestMapping(value="/mysurvey", method=RequestMethod.GET)
	public String selectAllSurvey(HttpSession session, Model model) throws Exception{
		MemberVO vo = (MemberVO) session.getAttribute("login");
		String m_id = vo.getM_id();
		model.addAttribute("list", service.selectMySurvey(m_id));
		return "mysurvey/mysurvey";
	} 
	
	
}
