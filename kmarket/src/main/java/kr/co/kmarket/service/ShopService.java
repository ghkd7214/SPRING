package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.ShopDao;
import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.Cate1Vo;
import kr.co.kmarket.vo.OrderDetailVo;
import kr.co.kmarket.vo.OrderVo;
import kr.co.kmarket.vo.ProductVo;

@Service
public class ShopService {

	@Autowired
	private ShopDao dao;
	
	public ProductVo selectTitles(int cate1, int cate2) {
		return dao.selectTitles(cate1, cate2);
	}
	
	public List<ProductVo> selectProducts(int cate1, int cate2, String sort){
		return dao.selectProducts(cate1, cate2, sort);
	}
	
	public ProductVo selectProduct(int code) {
		return dao.selectProduct(code);
	}
	
	public int selectCountCart(CartVo vo) {
		return dao.selectCountCart(vo);
	}
	
	public List<CartVo> selectCart(String uid) {
		return dao.selectCart(uid);
	}
	
	public int insertCart(CartVo vo) {
		return dao.insertCart(vo);
	}
	
	public int deleteCart(int[] cartSeqs) {
		return dao.deleteCart(cartSeqs);
	}
	
	public int insertOrder(OrderVo vo) {
		return dao.insertOrder(vo);
	}
	public int insertOrderDetail(int orderId, int code) {
		return dao.insertOrderDetail(orderId, code);
	}
	public List<OrderVo> selectOrder(String uid, int orderId){
		return dao.selectOrder(uid, orderId);
	}
}
