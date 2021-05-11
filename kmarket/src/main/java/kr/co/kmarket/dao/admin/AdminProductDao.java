package kr.co.kmarket.dao.admin;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.Cate1Vo;
import kr.co.kmarket.vo.Cate2Vo;
import kr.co.kmarket.vo.ProductVo;

@Repository
public interface AdminProductDao {

	public void insertProduct(ProductVo vo);

	public List<Cate1Vo> selectCate1();
	public List<Cate2Vo> selectCate2(int code1);

	public void selectProduct();
	public void selectProducts();
	public void updateProduct();
	public void deleteProduct();
	
}