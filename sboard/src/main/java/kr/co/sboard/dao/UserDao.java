package kr.co.sboard.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.TermsVo;
import kr.co.sboard.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSessionTemplate mybatis;

	public void insertUser() {}
	public TermsVo selectTerms() {
		return mybatis.selectOne("mapper.user.SELECT_TERMS");
	}
	public UserVo selectUser(UserVo vo) {
		return mybatis.selectOne("mapper.user.SELECT_USER, vo");
	}
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}
	
}
