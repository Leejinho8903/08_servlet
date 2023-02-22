package com.greedy.mvc.employee.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;
import com.greedy.mvc.employee.model.service.EmployeeService;


@WebServlet("/employee/insert")
public class InsertEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String empName = request.getParameter("empName");
		String empNo = request.getParameter("empNo");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String deptCode = request.getParameter("deptCode");
		String jobCode = request.getParameter("jobCode");
		String salLevel = request.getParameter("salLevel");
		int salary = Integer.parseInt(request.getParameter("salary"));
		double bonus = Double.parseDouble(request.getParameter("bonus"));
		String managerId = request.getParameter("managerId");
		Date hireDate = Date.valueOf(request.getParameter("hireDate"));
		
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmpName(empName);
		emp.setEmpNo(empNo);
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setDeptCode(deptCode);
		emp.setJobCode(jobCode);
		emp.setSalLevel(salLevel);
		emp.setSalary(salary);
		emp.setBonus(bonus);
		emp.setManagerId(managerId);
		emp.setHireDate(hireDate);
		
		System.out.println("insert request emp : " + emp);
		
		EmployeeService empService = new EmployeeService();
		int result = empService.insertEmp(emp);
		
		String path = "";
		
		// insert가 성공했을 경우 요청 url이 그대로 남아있으면 새로고침 시 다시 insert를 요청하게 되는 문제가 있다.
		// 따라서 redirect 처리가 필요하다.
		if(result > 0) {
			// main 화면으로 redirect
			// response.sendRedirect(request.getContextPath());
			
			// 신규 회원 등록 완료 메세지를 alert로 처리하기 위해서 successPage.jsp로 forward 후 메인 페이지를 다시 
			// 요청하는 프로세스로 변경
			request.setAttribute("successCode", "insertEmp");
			path = "/WEB-INF/views/common/successPage.jsp";
		} else {
			request.setAttribute("message", "신규 직원 등록에 실패하였습니다.");
			path = "/WEB-INF/views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
















