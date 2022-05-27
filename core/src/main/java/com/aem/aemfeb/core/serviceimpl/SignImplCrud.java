package com.aem.aemfeb.core.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aem.aemfeb.Employees;
import com.aem.aemfeb.core.databadeutil.DatabaseConnectionHelper;
import com.aem.aemfeb.core.service.SignUpCrudInterFaceI;
@Component(service=SignUpCrudInterFaceI.class,immediate=true)
public class SignImplCrud implements SignUpCrudInterFaceI{
	
	@Reference
	private DatabaseConnectionHelper hello;
	 Connection con=null;
	 PreparedStatement ps=null;
	 

	@Override
	public boolean registerEmployeeDetails(String name, String email, String age, String weight) {
		// TODO Auto-generated method stub
		String sqlQuery ="insert into employee values (?,?,?,?)";
		boolean flag=false;
		
		
		try {
			
		con=hello.getDataBaseConnection("test");	
		ps = con.prepareStatement(sqlQuery);

		ps.setString(1,name);
	    ps.setString(2, email);
	    ps.setString(3, age);
     	ps.setString(4, weight);
			int i=ps.executeUpdate();
			if(i==1) {
				flag= true;
				//log.info(Record inserted sucessfully");
			}else {
				flag=false;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			if (con!=null) {
			try {
				ps.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
			}
		}
		return flag;
	}

	@Override
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginEmployee() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployees(String name, String email, String age, String weight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployees(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}