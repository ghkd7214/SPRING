package kr.co.kmarket.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriesVo {

	private int code1;
	private String title;
	private List<Cate2Vo> cate2List;



}