package com.paypal.bfs.test.employeeserv.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.repo.EmployeeResourceRepository;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	
	@Autowired
	EmployeeResourceRepository employeeResourceRepository; 
	
    @Override
    public ResponseEntity<Employee> employeeGetById(Integer id){
    	Employee employee = null;
    	try {
    		employee = employeeResourceRepository.findById(id);
    		return new ResponseEntity<>(employee, HttpStatus.OK);
    	} 
    	/** Error Handling **/
    	catch (EmptyResultDataAccessException e) {
    		return new ResponseEntity("The employee you are looking for is not existed | Incorrect result size", HttpStatus.INTERNAL_SERVER_ERROR);
		} 
    	catch (Exception e) {
    		
    		 return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} 
    }

	@Override
	public ResponseEntity<Employee> createEmployee(Employee employee) {
		
		 try {
			 int createEmployee = employeeResourceRepository.createEmployee(employee);
	    	 return new ResponseEntity("Employee Added Successfully!", HttpStatus.OK);
		 }
		 /** Error Handling **/
		 catch (DataIntegrityViolationException e) {
       		 return new ResponseEntity("Unable to add employee please check the data you sent", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 catch (Exception e) {
	       	 return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	   	} 
	
	}
}
