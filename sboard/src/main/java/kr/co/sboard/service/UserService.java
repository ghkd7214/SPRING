package kr.co.sboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard.dao.UserDao;
import kr.co.sboard.vo.TermsVo;
import kr.co.sboard.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public void insertUser() {}
	public TermsVo selectTerms() {
		return dao.selectTerms();
	}
	public UserVo selectUser(UserVo vo) {
		return dao.selectUser(vo);
	}
	public void selectUsers() {}
	public void updateUser() {}
	public void deleteUser() {}
	
	
}
