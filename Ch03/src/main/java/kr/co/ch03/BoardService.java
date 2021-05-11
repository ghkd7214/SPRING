package kr.co.ch03;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	private LogAdvice log;

	public void insert() {
		log.beforeLog();
		System.out.println("ÇÙ½É°ü½É - insert");
		log.afterLog();
	}

	public void select() {
		System.out.println("ÇÙ½É°ü½É - select");
	}

	public void update() {
		System.out.println("ÇÙ½É°ü½É - update");
	}

	public void delete() {
		System.out.println("ÇÙ½É°ü½É - delete");
	}
}