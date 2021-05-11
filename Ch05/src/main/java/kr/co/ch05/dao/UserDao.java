package kr.co.ch05.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.co.ch05.vo.UserVo;

@Repository
public class UserDao {
	
	@Inject
	private	SqlSessionTemplate mybatis;

	
	public void insertUser(UserVo vo) {
		mybatis.insert("mapper.user.INSERT_USER",vo);
	}
	
	public UserVo selecttUser(String uid) {
		return mybatis.selectOne("mapper.user.SELECT_USER",uid);
	}
	
	public List<UserVo> selectUsers() {
		return mybatis.selectList("mapper.user.SELECT_USERS");
	}
	
	public void updateUser(UserVo vo) {
		mybatis.update("mapper.user.UPDATE_USER",vo);	
	}
	
	public void deleteUser(UserVo vo) {
		mybatis.delete("mapper.user.DELETE_USER",vo);
	}
	
}
