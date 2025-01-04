package com.krishna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krishna.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
