package com.greedy.section03.requestlistener;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 처음에 attributeReplaced()가 호출이 되는 이유는
		 * org.apache.catalina.ASYNC_SUPPORTED라는 attribute가 자동 수정 되기 때문에 한 번 호출을 된다.
		 * => 신경쓰지 않아도 됨
		 * */
		
		/* request에 attribute를 추가할 때 attributeAdded() 메소드가 동작한다. */
		request.setAttribute("username", "honggildong");
		request.setAttribute("age", 20);
		request.setAttribute("gender", "M");
		
		/* request에 attribute를 동일한 key로 덮어쓰는 경우 (value 수정) attributeReplaced() 메소드가 동작한다. */
		request.setAttribute("username", "hong");
		
		/* request에 attirubute를 제거할 때 attributeRemoved() 메소드가 동작한다. */
		request.removeAttribute("gender");
		
	}

}
