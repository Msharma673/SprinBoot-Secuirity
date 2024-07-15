package com.projectDemo3.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectDemo3.Entity.Employee;
import com.projectDemo3.Exception.CustomException;
import com.projectDemo3.Repository.EmployeeRepository;
import com.projectDemo3.Request.EmployeeRequest;
import com.projectDemo3.Response.BaseResponse;
import com.projectDemo3.Response.EmployeeResponse;
import com.projectDemo3.Response.FinalResponse;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	


	@Override
	public BaseResponse addEmployee(EmployeeRequest request) {
		
		BaseResponse finalres = new BaseResponse();
		
		try {
			Employee entity = new Employee();
			
			BeanUtils.copyProperties(request ,entity);
			
			employeeRepository.save(entity);
				
		}
		catch(Exception e) {
			throw new CustomException(false, e.getMessage());
		
		}
		finalres.setMessage("Data save successfully");
		finalres.setStatus(true);
		
		
		return	finalres;
	}

	@Override
	public FinalResponse getEmployee(Long id) {
		FinalResponse finalResponse= new FinalResponse();
		EmployeeResponse response = new EmployeeResponse();
		try {
		Optional<Employee> entity = employeeRepository.findById(id);
		BeanUtils.copyProperties(entity, response);
		
		finalResponse.setStatus(true);
		finalResponse.setMessage("Concept Detail Fetched");
		finalResponse.setData(response);
		}catch(Exception e) {
			throw new CustomException(false, e.getMessage());
		}
		return finalResponse;
	}
	@Override
	public FinalResponse getAllEmployee() {
		
		FinalResponse finalResponse= new FinalResponse();
		List<EmployeeResponse> employeeList = new ArrayList<>();
		try {
		List<Employee> findAll = employeeRepository.findAll();
		for(Employee conceptMaster: findAll) {
			EmployeeResponse employeeResponse = new EmployeeResponse();
			BeanUtils.copyProperties(conceptMaster, employeeResponse );
			employeeList.add(employeeResponse);
		}
			
			finalResponse.setStatus(true);
			finalResponse.setMessage("All Data Fetched");
			finalResponse.setData(employeeList);
		
		}catch(Exception e) {
			throw new CustomException(false, e.getMessage());
		}
		
		return finalResponse;
	
	}
	@Override
	public BaseResponse deleteEmployee(Long id) {
		BaseResponse res=new BaseResponse();
		try
		{
			Employee repo = employeeRepository.findById(id).get();
			employeeRepository.delete(repo);
			res.setStatus(true);
			res.setMessage("Data Deleted");
			
		}
		catch(Exception e) {
			throw new CustomException(false, e.getMessage());
		}
		return res;
	}

	@Override
	public FinalResponse updateEmployee(EmployeeRequest request, Long id) {
		FinalResponse res=new FinalResponse();
		EmployeeResponse response=new EmployeeResponse();
		try
		{
			Optional<Employee> repo = employeeRepository.findById(id);
			Employee conceptMaster = repo.get();
			
			BeanUtils.copyProperties(request, conceptMaster);
			
			
			Employee entity = employeeRepository.save(conceptMaster);
			BeanUtils.copyProperties(entity, response);
			res.setStatus(true);
			res.setMessage("conceptMaster updated successfully");
			res.setData(response);
			
		}
		catch(Exception e) {
			throw new CustomException(false, e.getMessage());
		}
		return res;
	}

}
