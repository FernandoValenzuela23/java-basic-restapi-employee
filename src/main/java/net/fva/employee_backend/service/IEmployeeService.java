package net.fva.employee_backend.service;

import java.util.List;

import net.fva.employee_backend.dto.EmployeeDto;

public interface IEmployeeService {
	EmployeeDto createEmployee(EmployeeDto emp);
	
	EmployeeDto getEmployee(Long id);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long id, EmployeeDto emp);	
	
	void deleteEmployee(Long id);
}
