package kr.co.ch03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 날짜 : 2021/04/13
 * 이름 : 이지황
 * 내용 : 스프링 AOP 실습하기
 * 
 * 스프링 AOP (Aspect Oriented Programming)
 * 	- 핵심관심과 전체에 적용되는 공통관심을 분리해서 프로그래밍하는 방식
 *
 * 포인트컷(Pointcut)
 *  - 조인포인트 가운데 실행되는 핵심관심 메서드
 *  
 * 어드바이스(Advice)
 *  - 횡단관심에 해당하는 공통의 부가기능 메서드
 *  
 * 에스펙트(Aspect)
 *  - 포인트컷과 어드바이스의 결합된 모듈형태
 *  
 * 위빙(Weaving)
 *  - 포인트컷이 실행될때 어드바이스가 포인트컷에 결합되는 과정
 *
 *
 */



public class AOPMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");

		BoardService service = (BoardService) ctx.getBean("boardService");
		service.insert();
		service.select();
		service.update();
		service.delete();

	}
}
