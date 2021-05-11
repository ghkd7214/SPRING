package kr.co.kmarket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model, HttpSession sess) {
		
		List<ProductVo> bestProducts = service.selectBestProducts();
		List<ProductVo> hitProducts = service.selectHitProducts();
		
		sess.setAttribute("bestProducts", bestProducts);
		model.addAttribute("hitProducts", hitProducts);
		
		return "/index";
	}
	
	@ResponseBody
	@GetMapping("/getRecommendProducts")
	public List<ProductVo> getRecommendProducts() {
		return service.selectRecommendProducts();
	}
	
	@ResponseBody
	@GetMapping("/getNewProducts")
	public List<ProductVo> getNewProducts() {
		return service.selectLatestProducts();
	}
	
	@ResponseBody
	@GetMapping("/getDiscountProducts")
	public List<ProductVo> getDiscountProducts() {
		return service.selectDiscountProducts();
	}
	
	@ResponseBody
	@GetMapping("/categories")
	public List<CategoriesVo> categories() {
		
		List<CategoriesVo> categories = service.selectCategories();
		return categories;
	}
	//sdas
}