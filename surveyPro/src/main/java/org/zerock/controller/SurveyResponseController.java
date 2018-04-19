package org.zerock.controller;

import java.util.HashMap;

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
public class SurveyResponseController {
	

	@Inject
	private SurveyService service;

	@RequestMapping(value="/surveyResponse", method=RequestMethod.GET)
	public String selectSurvey(Model model, @RequestParam("sv_id") int sv_id) throws Exception{	
		model.addAttribute("select", service.selectSurvey(sv_id));		
		model.addAttribute("title", service.selectTitle(sv_id));
		
		return "survey/surveyResponse";
	}
	
	@RequestMapping(value="/responseValue", method=RequestMethod.GET)
	public String insertResult(HttpSession session, Model model, @RequestParam("list_id") int list_id ,@RequestParam("selectValue") String list_content ) throws Exception{
		System.out.println("asdfasdafasfasfasfasfasf"+list_id);		
		MemberVO vo = (MemberVO) session.getAttribute("login");
		System.out.println(vo.getM_id());
		String m_id = vo.getM_id();
		model.addAttribute("list",service.insertResult(m_id,list_id));
		service.updateChunum(list_id);
		
		return "redirect:surveylist";
	}
	
	
	
	
}
