package com.greedy.section02.annotation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 등록하고 싶은 서블릿 클래스 상단에 @WebServlet 어노테이션으로 서블릿을 등록하고
 * 속성 값으로 mapping url을 작성한다.
 * loadOnStartup에 우선 순위를 지정하면(낮을수록 우선 순위가 높다) 서버가 start 될 때
 * 인스턴스를 생성하고 init을 호출한다. */
@WebServlet(value="/annotation-lifecycle", loadOnStartup = 1)
public class LifeCycleTestServlet extends HttpServlet{
	
	/* 메소드의 호출 횟수를 카운트 하기 위한 용도의 필드 */
	private int initCount = 1;
	private int serviceCount = 1;
	private int destroyCount = 1;
	
	
	/* 서블릿의 요청이 최초인 경우 한 번 동작하는 메소드 */ 
	@Override
	public void init() throws ServletException {
		System.out.println("annotation 매핑 init() 메소드 호출 : " + initCount++);
	}

	/* 서블릿의 요청이 일어낫을 때 동작하는 메소드
	 * 서블릿 컨테이너에 의해 호출 되며 최초 요청 시에는 init() 이후에 동작하고 두 번째 요청 부터는 바로 호출 된다. */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("annotation 매핑 service() 메소드 호출 : " + serviceCount++);
	}

	/* 컨테이너가 종료 될 때 호출 되는 메소드로 주로 자원을 반납하는 용도로 사용한다. */
	@Override
	public void destroy() {
		System.out.println("annotation 매핑 destroy() 메소드 호출 : " + destroyCount++);	
	}

}
