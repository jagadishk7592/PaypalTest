package com.paypal.bfs.test.employeeserv.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.Employee;


@Repository
public class EmployeeResourceRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Employee findById(Integer id) {
		 Employee employee = jdbcTemplate.queryForObject("SELECT * FROM employee where id=?", new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
		 if(employee.getId() >0 ) {
			 Address address = jdbcTemplate.queryForObject("SELECT * FROM address where id=?", new Object[]{employee.getAddressId()},new BeanPropertyRowMapper<Address>(Address.class));
			 employee.setAddress(address);
		 }
		 return employee;
	}

	public int createEmployee(Employee employee) {
		
		int update = jdbcTemplate.update("INSERT INTO address(line1, line2, city, state, country, zipCode) values (?, ?, ?, ?, ?, ?)", new Object[]{employee.getAddress().getLine1()
				 , employee.getAddress().getLine1(), employee.getAddress().getCity(), employee.getAddress().getState(), employee.getAddress().getCountry(), employee.getAddress().getZipCode()});
		System.err.println(update); 
		int update2 = jdbcTemplate.update("INSERT INTO employee(firstName, lastName, dateOfBirth, addressId) values (?, ?, ?, ?)", new Object[]{employee.getFirstName()
				 , employee.getLastName(), employee.getDateOfBirth(), update});
		
		return update2;
	}

}
