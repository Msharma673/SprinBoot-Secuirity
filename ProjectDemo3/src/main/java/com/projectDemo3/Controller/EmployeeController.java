package com.projectDemo3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectDemo3.Request.EmployeeRequest;
import com.projectDemo3.Response.BaseResponse;
import com.projectDemo3.Response.FinalResponse;
import com.projectDemo3.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/create-employee")
	public BaseResponse addEmployee(@RequestBody EmployeeRequest request) {
		return service.addEmployee(request);
	}
	
	@GetMapping("/view-all-employee")
	public FinalResponse getAllEmployee() {
		return service.getAllEmployee();
	}
	@GetMapping("/get-concept/{id}")
	public FinalResponse viewConcept(@PathVariable("id") Long id) {
		return service.getEmployee(id);
	}
	
	@PutMapping("/update-employee/{id}")
	public FinalResponse updateConcept(@RequestBody EmployeeRequest request,@PathVariable("id") Long id) {
		
		return service.updateEmployee(request, id);
		
	}
	@DeleteMapping("/delete-employee/{id}")
	public BaseResponse deleteConcept(@PathVariable("id") Long id)
	{
		return service.deleteEmployee(id);
	}
	
	

}
