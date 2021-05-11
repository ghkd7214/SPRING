package kr.co.ch05.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.ch05.dao.UserDao;
import kr.co.ch05.vo.UserVo;

@Service
public class UserService {
	
	@Inject
	private UserDao dao;
	
	public void insertUser(UserVo vo) {
		dao.insertUser(vo);
	}
	
	public UserVo selecttUser(String uid) {
		return dao.selecttUser(uid);
	}
		
	
	public List<UserVo> selectUsers() {
		return dao.selectUsers();
	}
	
	public void updateUser(UserVo vo) {
		dao.updateUser(vo);
		
	}
	public void deleteUser(UserVo vo) {
		dao.deleteUser(vo);
	}
}
