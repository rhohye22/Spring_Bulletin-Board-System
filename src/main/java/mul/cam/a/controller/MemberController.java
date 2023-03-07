package mul.cam.a.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mul.cam.a.dto.MemberDto;
import mul.cam.a.service.MemberService;
import mul.cam.a.service.impl.MemberServiceImpl;

@Controller
public class MemberController {
	// service 접근(생성)
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		System.out.println("MemberController login " + new Date());
		
		return "login";			
	}
	
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		System.out.println("MemberController regi " + new Date());
		
		return "regi";
	}
	

	@ResponseBody
	@RequestMapping(value = "idcheck.do", method = RequestMethod.POST)
	public String idcheck(String id) {
		System.out.println("MemberController idcheck " + new Date());
		
		boolean isS = service.idCheck(id);
		if(isS == true) {	// id가 있음
			return "NO";
		}
		
		return "YES";	// id가 없음
	}
	
	@RequestMapping(value = "regiAf.do", method = RequestMethod.POST)
	public String regiAf(Model model, MemberDto dto) {
		System.out.println("MemberController regiAf " + new Date());
		
		boolean isS = service.addMember(dto);
		String message = "";
		if(isS) {
			message = "MEMBER_ADD_YES";
		}else {
			message = "MEMBER_ADD_NO";
		}
		model.addAttribute("message", message);
		
		return "message";
	}
	

	@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
	public String login(Model model, MemberDto dto, HttpServletRequest request) {
		System.out.println("MemberController login " + new Date());
		
		MemberDto mem = service.loginDto(dto);
		
		boolean isS = service.login(dto);
		String YN = "";
		if(isS) {
			YN = "MEMBER_YES";
			
			HttpSession session = request.getSession();
			session.setAttribute("login", mem);
		//session.setMaxInactiveInterval(5);//시간 정할 수 있음, 기본이 30분0	
			
			
		}else {
			YN = "MEMBER_NO";
		}
		model.addAttribute("login", mem);
		model.addAttribute("YN", YN);
		
		return "message";
	}
	
	
	
}












