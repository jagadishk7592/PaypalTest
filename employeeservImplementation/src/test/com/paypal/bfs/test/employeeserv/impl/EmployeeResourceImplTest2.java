package com.paypal.bfs.test.employeeserv.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.paypal.bfs.test.employeeserv.api.model.Employee;


class EmployeeResourceImplTest2 {
    EmployeeResourceImpl emplResourceImpl =  new EmployeeResourceImpl();
	@Test
	void testEmployeeGetById() {
		assertEquals(Object.class, emplResourceImpl.employeeGetById(1));
		
	}

	@Test
	void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("jhon");
		employee.setLastName("Mathews");
		employee.setDateOfBirth("10-02-1993");
		assertEquals(Object.class, emplResourceImpl.createEmployee(employee));
	}

}
