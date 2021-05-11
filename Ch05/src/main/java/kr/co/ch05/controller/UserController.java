package kr.co.ch05.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch05.service.UserService;
import kr.co.ch05.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping ("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping ("/user/register")
	public String register(UserVo vo) {	
		service.insertUser(vo);		
		return "redirect:/user/list";
	}

	@GetMapping("/user/list")
	public String list(Model model) {
		List<UserVo> users = service.selectUsers();
		
		model.addAttribute("users",users);
		return "/user/list";
	}
	
	@GetMapping("/user/modify")
	public String modify(String uid, Model model) {
		UserVo vo = service.selecttUser(uid);
		
		model.addAttribute(vo);
		return "/user/modify";
	}
	
	@PostMapping("/user/modify")
	public String modify(UserVo vo) {
		service.updateUser(vo);
		return "redirect:/user/list";
	}
	
	@GetMapping
	public String delete(UserVo vo) {
		service.deleteUser(vo);
		return "redirect:/user/list";
	}
	

}
