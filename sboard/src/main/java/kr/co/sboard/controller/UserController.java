package kr.co.sboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard.service.UserService;
import kr.co.sboard.vo.TermsVo;
import kr.co.sboard.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/user/login")
	public String login(String result, Model model) {

		model.addAttribute("result", result);
		return "/user/login";
	}
	
	@GetMapping("/user/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/user/login";
	}
	
	@PostMapping("/user/login")
	public String login(UserVo vo, HttpSession sess) {

		UserVo user = service.selectUser(vo);

		if(user != null) {
			sess.setAttribute("suser", user);
			return "redirect:/list";			
		}else {
			return "redirect:/user/login";
		}
	}
	
	@GetMapping("/user/terms")
	public String terms(Model model) {

		TermsVo vo = service.selectTerms();

		model.addAttribute(vo);

		return "/user/terms";
	}


	
}
