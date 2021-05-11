package kr.co.ch02.sub1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * ��¥ : 2021/04/12
 * �̸� : ����Ȳ
 * ���� : ������ Ioc �ǽ��ϱ�
 */

public class IocTest1 {
	
	public static void main(String[] args) {
		
		//Ioc���� x
		
		Tv ltv = new LgTv();
		ltv.power();
		ltv.chUp();
		ltv.chDown();
		
		Tv stv = new SamsungTv();
		stv.power();
		stv.chUp();
		stv.chDown();
		
		
		
		//Ioc���� o
		
		//������ �����̳� ��ü
		ApplicationContext ctx = new GenericXmlApplicationContext("spring-context.xml");
		
		Tv lgtv = (Tv) ctx.getBean("lgtv");
		Tv smtv = (Tv) ctx.getBean("smtv");
		
		lgtv.power();
		lgtv.chUp();
		lgtv.chDown();
		
		smtv.power();
		smtv.chUp();
		smtv.chDown();
		
	}

}