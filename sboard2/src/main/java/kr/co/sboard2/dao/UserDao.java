package kr.co.sboard2.dao;

import org.springframework.stereotype.Repository;

import kr.co.sboard2.vo.UserVo;

@Repository
public interface UserDao {

	public void insertUser(UserVo vo);
	public UserVo selectUser(String uid);
	public void selectUsers();
	public void updateUser();
	public void deleteUser();
	
}
