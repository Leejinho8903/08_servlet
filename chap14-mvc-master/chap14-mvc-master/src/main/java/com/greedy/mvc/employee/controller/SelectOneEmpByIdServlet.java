package com.greedy.mvc.employee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;
import com.greedy.mvc.employee.model.service.EmployeeService;


@WebServlet("/employee/select")
public class SelectOneEmpByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 1. 클라이언트에서 전달 된 파라미터 꺼내고 검증 */
		String empId = request.getParameter("empId");
		System.out.println("empId : " + empId);
		
		/* 2. 사번을 이용해 사원 정보를 조회하는 비즈니스 로직 호출 */
		EmployeeService empService = new EmployeeService();
		EmployeeDTO selectedEmp = empService.selectOneEmpById(empId);
		System.out.println("selectedEmp : " + selectedEmp);
		
		/* 3. 조회 된 사원 정보를 나타내는 응답 페이지 jsp로 위임해서 처리 */
		String path = "";
		if(selectedEmp != null) {
			path = "/WEB-INF/views/employee/showEmpInfo.jsp";
			request.setAttribute("selectedEmp", selectedEmp);
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "해당 사번을 가진 직원은 없습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

	
}










