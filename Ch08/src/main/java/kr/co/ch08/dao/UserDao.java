package kr.co.ch08.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.UserVo;

@Repository
public interface UserDao {
	
	public void insertUser(UserVo vo);
	public UserVo selectUser(String uid);
	public List<UserVo> selectUsers();
	public void updateUser(UserVo vo);
	public void deleteUser(String uid);
	
}
