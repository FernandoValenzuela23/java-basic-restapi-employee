package net.fva.employee_backend.mapper;

import net.fva.employee_backend.dto.EmployeeDto;
import net.fva.employee_backend.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToEmployeeDto(Employee emp)
	{
		return new EmployeeDto(
			emp.getId(),
			emp.getFirstName(),
			emp.getLastName(),
			emp.getEmail()
		);
	}
	
	public static Employee mapToEmployee(EmployeeDto emp)
	{
		return new Employee(
			emp.getId(),
			emp.getFirstName(),
			emp.getLastName(),
			emp.getEmail()
		);
	}
}
