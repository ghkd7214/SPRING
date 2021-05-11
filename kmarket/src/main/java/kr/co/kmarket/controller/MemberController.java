package kr.co.kmarket.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/member/login")
	public String login(String result, Model model) {

		if(result != null) {
			int value = Integer.parseInt(result);
			model.addAttribute("result", value);
		}
		
		
		
		return "/member/login";
	}

	@PostMapping("/member/login")
	public String login(MemberVo vo, HttpSession sess) {

		String result = vo.getResult();
		
		MemberVo member = service.selectMember(vo);

		if(member != null) {
			// 일치하는 회원이 맞으면
			sess.setAttribute("smember", member);

			if(result.equals("0")) {
				return "redirect:/";	
			}else if(result.equals("1")) {
				return "redirect:/shop/cart";
			}else {
				return "redirect:/";
			}
		}else {
			// 일치하는 회원이 없으면
			return "redirect:/member/login?result=0";
		}
	}
	
	@GetMapping("/member/join")
	public String join() {
		return "/member/join";
	}

	@GetMapping("/member/signup")
	public String signup() {
		return "/member/signup";
	}

	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}

	@GetMapping("/member/register-seller")
	public String registerSeller() {
		return "/member/register-seller";
	}
}