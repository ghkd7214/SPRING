package kr.co.sboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.service.BoardService;
import kr.co.sboard.vo.ArticleVo;
import kr.co.sboard.vo.FileVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	
	@GetMapping("/list")
	public String list(String pg, Model model) {
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		int total = service.selectCountArticle();
		int pageStartNum = service.getPageStartNum(total, start);
		int lastPageNum = service.getLastPageNum(total);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		List<ArticleVo> articles = service.selectArticles(start);
		
		model.addAttribute("articles", articles);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("groups", groups);
		
		return "/list";
	}

	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest req, ArticleVo vo) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		// spring-context.xml 파일업로드 설정 할 것
		MultipartFile file = vo.getFname();
		
		if(file.isEmpty()) {
			vo.setFile(0);
		}else {
			vo.setFile(1);
		}
		
		// 글 insert한 후 글번호를 받아옴 
		int seq = service.insertArticle(vo);
		
		FileVo fvo = service.fileUpload(req, file, seq);
		
		if(fvo != null) {
			service.insertFile(fvo);			
		}	
		
		return "redirect:/list";
	}
	
}