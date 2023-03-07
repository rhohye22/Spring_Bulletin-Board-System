package mul.cam.a.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mul.cam.a.dto.BbsDto;
import mul.cam.a.dto.BbsParam;
import mul.cam.a.dto.MemberDto;
import mul.cam.a.service.BbsService;

@Controller
public class BbsController {

	@Autowired
	BbsService service;

	@GetMapping(value = "bbslist.do")
	public String bbslist(Model model, BbsParam param) {

		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 10); // 1 11
		int end = (pn + 1) * 10; // 10 20

		param.setStart(start);
		param.setEnd(end);

		List<BbsDto> list = service.bbslist(param);
		int len = service.bbsCnt();
		System.out.println("len : " + len);
		int pageBbs = len / 10; // 25 / 10 -> 2
		if ((len % 10) > 0) {
			pageBbs = pageBbs + 1;
		}

		if (param.getChoice() == null || param.getChoice().equals("") || param.getSearch() == null || param.getSearch().equals("")) {
			param.setChoice("검색");
			param.setSearch("");
		}

		model.addAttribute("bbslist", list); // 게시판 리스트
		model.addAttribute("pageBbs", pageBbs); // 총 페이지수
		model.addAttribute("pageNumber", param.getPageNumber()); // 현재 페이지
		model.addAttribute("choice", param.getChoice()); // 검색 카테고리
		model.addAttribute("search", param.getSearch()); // 검색어

		return "bbslist";
	}

	@GetMapping(value = "bbsdetail.do")
	public String bbsdetail(Model model, int seq) {
		BbsDto dto = service.getDto(seq);
		service.readcount(seq);
		model.addAttribute("bbsdto", dto);

		return "bbsdetail";
	}

	@RequestMapping(value = "bbswrite.do", method = RequestMethod.GET)
	public String bbswrite() {
		return "bbswrite";

	}

	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.GET)
	public String bbswriteAf(Model model, BbsDto dto) {

		boolean b = service.addBbs(dto);

		return "redirect:/bbslist.do";
	}

	@RequestMapping(value = "logout.do")
	public String logout(Model model, HttpServletRequest request, HttpSession session) {
		// HttpSession session = request.getSession();
		MemberDto login = (MemberDto) session.getAttribute("login");
		session.removeAttribute("login");
		model.addAttribute("login", login);

		return "redirect:/login.do";
	}

	@RequestMapping(value = "answer.do", method = RequestMethod.GET)
	public String answer(Model model, int seq) {
		BbsDto dto = service.getDto(seq);
		model.addAttribute("dto", dto);

		return "answer";
	}

	@RequestMapping(value = "answerAf.do", method = RequestMethod.POST)
	public String answerAf(Model model, BbsDto dto) {

		boolean b = service.addAnswer(dto);
		
		if (b) {
			return "redirect:/bbslist.do";
		} else {
			String answer = "answer_added_fail";
			model.addAttribute("answer", answer);

			return "message";
		}
		

		

	}

	/*	 */

}
