package com.greedy.section02.uses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {

	/* 부모 클래스에 기본 생성자가 존재하지 않으므로 자식 클래스에서도 request를 부모 클래스로 전달해주는 생성자가 필요하다. */
	public RequestWrapper(HttpServletRequest request) {
		super(request);
		
	}

	/* request 객체의 나머지 기능은 원래 기능을 그대로 사용하고 getParameter 메소드만
	 * overriding해서 재정의한 메소드를 호출하도록 한다. */
	@Override
	public String getParameter(String name) {
		
		String value = "";
		
		if("password".equals(name)) {
			/* 암호화 로직 작성 */
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(name));
		} else {
			value = super.getParameter(name);
		}
		
		return value;
	}
	
	
}
