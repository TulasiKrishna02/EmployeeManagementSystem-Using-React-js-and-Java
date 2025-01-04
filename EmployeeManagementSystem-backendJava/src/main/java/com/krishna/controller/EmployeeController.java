package com.krishna.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krishna.dto.EmployeeDto;
import com.krishna.service.EmployeeService;

import lombok.AllArgsConstructor;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	//Build add Employee Rest API
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto employee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(employee,HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeById = employeeService.getEmployeeById(employeeId);
		
		return new ResponseEntity<EmployeeDto>(employeeById,HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
		return ResponseEntity.ok(allEmployees);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updatedEmployee(@PathVariable("id")  Long employeeId,@RequestBody EmployeeDto updatedEmp){
		EmployeeDto updateEmployee = employeeService.updateEmployee(employeeId, updatedEmp);
		return ResponseEntity.ok(updateEmployee);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeid){
		employeeService.deleteEmployee(employeeid);
		return ResponseEntity.ok("Employee deleted sucessfully with the id"+employeeid);
	}

}
