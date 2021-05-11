package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CartVo;
import kr.co.kmarket.vo.OrderDetailVo;
import kr.co.kmarket.vo.OrderVo;
import kr.co.kmarket.vo.ProductVo;

@Repository
public interface ShopDao {
	
	public ProductVo selectTitles(int cate1, int cate2);
	public List<ProductVo> selectProducts(int cate1, int cate2, String sort);
	public ProductVo selectProduct(int code);
	
	public int selectCountCart(CartVo vo);
	public List<CartVo> selectCart(String uid);
	public int insertCart(CartVo vo);
	public int deleteCart(int[] cartSeqs);
	
	public int insertOrder(OrderVo vo);
	public int insertOrderDetail(int orderId, int code);
	
	public List<OrderVo> selectOrder(String uid, int orderId);
}