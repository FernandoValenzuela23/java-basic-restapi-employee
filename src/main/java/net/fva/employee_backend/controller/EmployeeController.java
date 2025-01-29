package net.fva.employee_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.fva.employee_backend.dto.EmployeeDto;
import net.fva.employee_backend.entity.Employee;
import net.fva.employee_backend.service.impl.EmployeeService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto emp)
	{
		EmployeeDto result = employeeService.createEmployee(emp);
		if(result != null)
		{
			return new ResponseEntity<EmployeeDto>(result, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<EmployeeDto>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id)
	{
		EmployeeDto result = employeeService.getEmployee(id);
		
		return  ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees()
	{
		List<EmployeeDto> result = employeeService.getAllEmployees();
		
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto emp)
	{
		EmployeeDto result = employeeService.updateEmployee(id, emp);
		
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id)
	{
		employeeService.deleteEmployee(id);
		
		return ResponseEntity.ok("Employee deleted successfully");
	}

}
