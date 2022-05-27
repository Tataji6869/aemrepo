package com.aem.aemfeb.core.service;

import java.util.List;

import com.aem.aemfeb.Employees;

public interface SignUpCrudInterFaceI {

	public boolean registerEmployeeDetails(String name,String email,String age,String weight);
	public List<Employees> getAllEmployees();
	public boolean loginEmployee();
	public boolean updateEmployees(String name,String email,String age,String weight);
	public boolean deleteEmployees(String name);
}
