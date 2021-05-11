package kr.co.ch05.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch05.service.MemberService;
import kr.co.ch05.vo.MemberVo;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping ("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping ("/member/register")
	public String register(MemberVo vo) {	
		service.insertMember(vo);	
		return "redirect:/member/list";
	}

	@GetMapping("/member/list")
	public String list(Model model) {
		List<MemberVo> members = service.selectMembers();
		
		//View에서 데이터 출력을 위해 model 객체로 데이터 공유
		model.addAttribute("members",members);
		return "/member/list";
	}
		
	@GetMapping("/member/modify")
	public String modify(String uid, Model model) {
		MemberVo vo = service.selectMember(uid);
		
		model.addAttribute(vo);
		return "/member/modify";
	}
	
	@PostMapping("/member/modify")
	public String modify(MemberVo vo) {
		service.updateMember(vo);
		return "redirect:/member/list";
	}
	
	
	@GetMapping ("/member/delete")
	public String delete(MemberVo vo) {
		service.deleteMember(vo);
		return "redirect:/member/list";
	}

}
