package org.zerock.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.service.SurveyService;

@Controller
@RequestMapping("/survey/*")
public class SurveyController {
	
	@Inject
	private SurveyService service;
	
	@RequestMapping(value="/surveylist", method=RequestMethod.GET)
	public String selectAllSurvey(Model model) throws Exception{
		model.addAttribute("list", service.selectAllSurvey());
		return "survey/surveylist";
	} 
	
	
}
