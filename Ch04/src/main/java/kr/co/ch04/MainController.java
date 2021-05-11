package kr.co.ch04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = {"/", "/index"})
	public String index() {
		return "index";
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/greeting")
	public String greeting() {
		return "greeting";
	}


}