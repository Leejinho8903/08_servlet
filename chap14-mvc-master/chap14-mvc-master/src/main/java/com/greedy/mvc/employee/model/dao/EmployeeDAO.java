package com.greedy.mvc.employee.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.greedy.mvc.employee.model.dto.EmployeeDTO;

public class EmployeeDAO {

	public EmployeeDTO selectOneEmpById(SqlSession session, String empId) {
		
		return session.selectOne("EmployeeDAO.selectOneEmpById", empId);
	}

	public List<EmployeeDTO> selectAllEmp(SqlSession session) {
		
		return session.selectList("EmployeeDAO.selectAllEmp");
	}

	public int insertEmp(SqlSession session, EmployeeDTO emp) {
		
		return session.insert("EmployeeDAO.insertEmp", emp);
	}

	public int updateEmp(SqlSession session, EmployeeDTO emp) {
		
		return session.update("EmployeeDAO.updateEmp", emp);
	}

	public int deleteEmp(SqlSession session, String empId) {
		
		return session.delete("EmployeeDAO.deleteEmp", empId);
	}

}
