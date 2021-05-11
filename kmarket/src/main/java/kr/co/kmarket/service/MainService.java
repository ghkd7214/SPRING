package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MainDao;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductVo;

@Service
public class MainService {

	@Autowired
	private MainDao dao;

	public List<CategoriesVo> selectCategories(){
		return dao.selectCategories();
	}

	public List<ProductVo> selectBestProducts(){
		return dao.selectBestProducts();
	}
	public List<ProductVo> selectHitProducts(){
		return dao.selectHitProducts();
	}
	public List<ProductVo> selectRecommendProducts(){
		return dao.selectRecommendProducts();
	}
	public List<ProductVo> selectLatestProducts(){
		return dao.selectLatestProducts();
	}
	public List<ProductVo> selectDiscountProducts(){
		return dao.selectDiscountProducts();
	}

	
}
