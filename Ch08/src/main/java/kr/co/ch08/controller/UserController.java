package kr.co.ch08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ch08.service.UserService;
import kr.co.ch08.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/user/list")
	public String list(Model model) {
		
		List<UserVo> users = service.selectUsers();
		
		model.addAttribute("users", users);
		
		return "/user/list";
		
	}
	
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(UserVo vo) {
		service.insertUser(vo);
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/modify")
	public String modify(String uid , Model model) {
		
		UserVo user = service.selectUser(uid);
		
		model.addAttribute(user);
		
		return "/user/modify";
	}
	@PostMapping("/user/modify")
	public String modify(UserVo vo) {

		service.updateUser(vo);

		return "redirect:/user/list";
	}

	@GetMapping("/user/delete")
	public String delete(String uid) {

		service.deleteUser(uid);

		return "redirect:/user/list";
	}
	
	
}
