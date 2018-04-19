package org.zerock.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.core.RemoveTag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;
import org.zerock.service.MemberService;

@Controller
@RequestMapping("/joinus/*")
public class LoginController {
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() throws Exception{

		return "joinus/login";
	} 
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String lougout(HttpSession session) throws Exception{
		
		session.removeAttribute("login");
		
		return "redirect:..";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginDTO dto, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception{
		
		MemberVO vo = service.login(dto);
		
		if (vo==null) { // 아이디가 없을 경우. 
			
			model.addAttribute("error", "ID를 다시 입력해 주세요.");
			return "joinus/login";
			
		} else {
			
			if (!vo.getM_pw().equals(dto.getM_pw())) {
				model.addAttribute("error", "password를 다시 입력해주세요.");
				return "joinus/login";
			} else {
				
				model.addAttribute("MemberVO", vo);	
				session.setAttribute("login", vo);
				
				return "redirect:../survey/surveylist";
			}
		}
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() throws Exception{
		return "/joinus/join";
	} 
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(MemberVO vo) throws Exception{
		
		System.out.printf("> %s - %s\n", vo.getM_name(), vo.getM_gender());
		
		service.insertMember(vo);
		
		
		return "redirect:../joinus/login";
	} 
	
	@RequestMapping(value="/check", method=RequestMethod.POST)
	@ResponseBody
	public String DueId(HttpServletRequest request) throws Exception{
		String m_id = request.getParameter("m_id");
		int count = service.DueId(m_id);
		return String.valueOf(count);
	} 
	
	@RequestMapping(value="/unregister", method=RequestMethod.GET)
	public String unregister(HttpSession session) throws Exception{
		MemberVO vo = (MemberVO) session.getAttribute("login");
		String m_id = vo.getM_id();
		service.deleteMember(m_id);
		session.removeAttribute("login");
		return "redirect:..";
	}
	
}
