package kr.co.sboard.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.sboard.dao.BoardDao;
import kr.co.sboard.vo.ArticleVo;
import kr.co.sboard.vo.FileVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public int insertArticle(ArticleVo vo) {
		return dao.insertArticle(vo);
	}
	
	public void insertFile(FileVo fvo) {
		dao.insertFile(fvo);
	}
		
	public int selectCountArticle() {
		return dao.selectCountArticle();
	}
	public ArticleVo selectArticle(int seq) {
		return dao.selectArticle(seq);
	}
	
	public List<ArticleVo> selectArticles(int start) {
		return dao.selectArticles(start);
	}
	
	public void updateArticle() {}
	public void deleteArticle() {}
	
	// 게시판 리스트 페이지 번호 처리관련 메서드
	public int getPageStartNum(int total, int start) {
		return total - start;
	}
	
	// 게시판 리스트 페이지 처리관련 메서드
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		
		int groupCurrent = (int) Math.ceil(currentPage / 10.0);
		int groupStart   = (groupCurrent - 1) * 10 + 1;
		int groupEnd     = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
	// 게시판 리스트 페이지 처리관련 메서드
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		return currentPage;
	}
	// 게시판 리스트 페이지 처리관련 메서드
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
	}
	// 게시판 리스트 페이지 처리관련 메서드
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0) {
			lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 + 1;
		}
		
		return lastPageNum;
	}
	
	// 파일 업로드
	public FileVo fileUpload(HttpServletRequest req, MultipartFile file, int seq) {
		
		// spring-context.xml - '/resources/file/' 경로 설정등록
		String path = req.getSession().getServletContext().getRealPath("/resources/file/");
		
		if(!file.isEmpty()) {
			// 파일 첨부 했을때
			String oName = file.getOriginalFilename();
			String ext = oName.substring(oName.lastIndexOf("."));
			
			// 고유파일명 생성
			String uName = UUID.randomUUID().toString()+ext;
			
			// 파일 저장
			try {
				file.transferTo(new File(path+uName));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			FileVo vo = new FileVo();
			vo.setParent(seq);
			vo.setOldName(oName);
			vo.setNewName(uName);
			
			return vo;
			
		}else {
			// 파일 첨부 안했을때
			return null;
		}	
	}
	
	
	// 파일 다운로드
	public void fileDownload() {
		
	}
	
}