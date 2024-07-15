package com.projectDemo3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectDemo3.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
