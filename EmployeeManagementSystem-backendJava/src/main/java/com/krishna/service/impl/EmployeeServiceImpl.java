package com.krishna.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.krishna.dto.EmployeeDto;
import com.krishna.entity.Employee;
import com.krishna.exception.ResourceNotFoundException;
import com.krishna.mapper.EmployeeMapper;
import com.krishna.repository.EmployeeRepository;
import com.krishna.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repo;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = repo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {

		Employee employee = repo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id :" + employeeId));

		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = repo.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = repo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id" + employeeId));
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		Employee updatedEmploye = repo.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmploye);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = repo.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee is not exist with given id" + employeeId));

		repo.deleteById(employeeId);
	}

}
