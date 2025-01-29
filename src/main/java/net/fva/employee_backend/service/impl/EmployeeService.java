package net.fva.employee_backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.fva.employee_backend.dto.EmployeeDto;
import net.fva.employee_backend.entity.Employee;
import net.fva.employee_backend.exception.ResourceNotFoundException;
import net.fva.employee_backend.mapper.EmployeeMapper;
import net.fva.employee_backend.repository.IEmployeeRepository;
import net.fva.employee_backend.service.IEmployeeService;

@AllArgsConstructor
@Service
public class EmployeeService implements IEmployeeService {

	private IEmployeeRepository employeeRepository;	
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto emp) {
		Employee employee = EmployeeMapper.mapToEmployee(emp);
		Employee saved = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(saved);
	}

	@Override
	public EmployeeDto getEmployee(Long id) {
		Employee result = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
		
		return EmployeeMapper.mapToEmployeeDto(result);
		
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> result = employeeRepository.findAll();
		return result.stream().map((e) -> EmployeeMapper.mapToEmployeeDto(e)).toList();
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto emp) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
		
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setEmail(emp.getEmail());
		
		Employee result = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(result);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee result = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
		
		
		employeeRepository.deleteById(id);
	}

}
