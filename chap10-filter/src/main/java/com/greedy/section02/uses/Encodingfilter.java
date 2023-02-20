package com.greedy.section02.uses;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/* 필터 등록은 web.xml에서 처리 */
public class Encodingfilter extends HttpFilter implements Filter {
      
	private String encodingType;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		/* POST 방식으로 요청 되었을 경우 문자 인코딩이 필요하므로 확인해서 인코딩으로 설정 */
		HttpServletRequest hrequest = (HttpServletRequest) request;
		if("POST".equals(hrequest.getMethod())) {
			request.setCharacterEncoding(encodingType);
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		/* web.xml에서 필터 등록 시 기재한 init-param의 key를 이용하여 fConfig에서 꺼낼 수 있다. */
		encodingType = fConfig.getInitParameter("encoding-type");
	}

}
