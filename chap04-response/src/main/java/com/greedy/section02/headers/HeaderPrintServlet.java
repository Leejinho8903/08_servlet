package com.greedy.section02.headers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/headers")
public class HeaderPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* request header 출력 */
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			System.out.println("name : " + headerName);	
			System.out.println("value : " + request.getHeader(headerName));
		}
		
		System.out.println("-------------------------------------------------------");
		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Refresh", "1");
		
		PrintWriter out = response.getWriter();
		
		long currentTime = System.currentTimeMillis();
		
		out.print("<h1>" + currentTime + "</h1>");
		out.flush();
		out.close();
		
		/* response header 출력 */
		Collection<String> responseHeaders = response.getHeaderNames();
		Iterator<String> iter = responseHeaders.iterator();
		while(iter.hasNext()) {
			String headerName = iter.next();
			System.out.println("name1 : " + headerName);
			System.out.println("value1 : " + response.getHeader(headerName));
		}
		
	}

	
}
