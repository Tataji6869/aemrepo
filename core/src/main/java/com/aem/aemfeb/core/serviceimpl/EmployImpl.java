package com.aem.aemfeb.core.serviceimpl;

import org.osgi.service.component.annotations.Component;

import com.aem.aemfeb.core.service.EmployI;
@Component(service=EmployI.class,immediate=true)
public class EmployImpl implements EmployI{

	@Override
	public String getEmployDetails() {
		
		try {
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return "apple";
	}


	
	
	
	

}
