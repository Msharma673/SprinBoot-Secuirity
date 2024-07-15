package com.projectDemo3.Service;

import com.projectDemo3.Request.EmployeeRequest;
import com.projectDemo3.Response.BaseResponse;
import com.projectDemo3.Response.FinalResponse;

public interface EmployeeService {
	
	
BaseResponse addEmployee(EmployeeRequest request);
	
	FinalResponse getEmployee(Long id);
	
	FinalResponse getAllEmployee();
	

	BaseResponse deleteEmployee(Long id);

	FinalResponse updateEmployee(EmployeeRequest request,Long id);
	
	


}
