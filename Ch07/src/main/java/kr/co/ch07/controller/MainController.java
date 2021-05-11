package kr.co.ch07.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ch07.vo.UserVo;

@Controller
public class MainController {

	@GetMapping(value = {"/","/index"})
	public String index(Model model) {
		
		
		String title = "SpringBoot Thymeleaf Pratice";
		String hello = "Hello Thymeleaf";
		
		UserVo user = new UserVo();
		
		user.setUid("a101");
		user.setName("홍길동");
		user.setHp("010-1234-5678");
		user.setAge(20);
		
		List<UserVo> users = new ArrayList<>();
		
		users.add(new UserVo("a101","김유신","010-1234-1111",21));
		users.add(new UserVo("a102","김유신","010-1234-2222",21));
		users.add(new UserVo("a103","김유신","010-1234-3333",21));
		users.add(new UserVo("a104","김유신","010-1234-4444",21));
		users.add(new UserVo("a105","김유신","010-1234-5555",21));
		
		
		model.addAttribute("title", title);
		model.addAttribute("hello", hello);
		model.addAttribute("user", user);
		model.addAttribute("users", users);
		
		
		return "/index";
	}
	
	@GetMapping("/include")
	public String include() {
		return "/include";
	}
	
	
}
