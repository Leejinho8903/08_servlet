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

@WebServlet("/employee/update")
public class UpdateEmpServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empId = request.getParameter("empId");
		Date entDate = Date.valueOf(request.getParameter("entDate"));
		
		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmpId(empId);
		emp.setEntDate(entDate);
		
		int result = new EmployeeService().updateEmp(emp);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/successPage.jsp";
			request.setAttribute("successCode", "updateEmp");
		} else {
			path = "/WEB-INF/views/common/errorPage.jsp";
			request.setAttribute("message", "회원 정보 수정에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}












