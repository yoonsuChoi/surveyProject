package org.zerock.controller;

import java.util.HashMap;
import java.util.List;

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
	public String selectSurvey(HttpSession session,Model model, @RequestParam("sv_id") int sv_id) throws Exception{

		MemberVO vo = (MemberVO) session.getAttribute("login");		
		String m_id = vo.getM_id();
		System.out.println(m_id);
		System.out.println(sv_id);
	    List<SurveyVO> asdf = service.resultCheck(m_id, sv_id);
		System.out.println(asdf+"ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		if(asdf.isEmpty()) {
			model.addAttribute("select", service.selectSurvey(sv_id));		
			model.addAttribute("title", service.selectTitle(sv_id));
			
			return "survey/surveyResponse";
		}else{
			return "redirect:surveylist";

		}
		
	}
	
	@RequestMapping(value="/responseValue", method=RequestMethod.GET)
	public String insertResult(HttpSession session, Model model, @RequestParam("list_id") int list_id ,@RequestParam("selectValue") String list_content ) throws Exception{	
		
		MemberVO vo = (MemberVO) session.getAttribute("login");		
		String m_id = vo.getM_id();
		model.addAttribute("list",service.insertResult(m_id,list_id));
		System.out.println("여기까지");
		service.updateChunum(list_id);
		
		return "redirect:surveylist";
	}
	
	
	
	
}
