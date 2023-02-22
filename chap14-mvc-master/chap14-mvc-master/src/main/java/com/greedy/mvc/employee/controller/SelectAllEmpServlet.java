package com.greedy.mvc.employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;
import com.greedy.mvc.employee.model.service.EmployeeService;


@WebServlet("/employee/list")
public class SelectAllEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 전체 사원의 정보 조회 결과에 따라 employee/employeeList.jsp or common/errorPage.jsp 로 응답 */
		
		/* 1. 클라이언트에서 전달 된 파라미터 꺼내고 검증 => 전달 된 파라미터 없음 */
		
		/* 2. 전체 사원 정보를 조회하는 비즈니스 로직 호출 */
		EmployeeService empService = new EmployeeService();
		List<EmployeeDTO> empList = empService.selectAllEmp();
		
		/* 3. 조회 된 사원 정보를 나타내는 응답 페이지 jsp로 위임해서 처리 */
		String path = "";
		if(empList != null) {
			path = "/WEB-INF/views/employee/employeeList.jsp";
			request.setAttribute("empList", empList);
		} else {
			path = "/WEB-INF/common/errorPage.jsp";
			request.setAttribute("message", "직원 전체 목록 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}
