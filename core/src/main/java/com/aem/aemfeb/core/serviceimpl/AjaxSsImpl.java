package com.aem.aemfeb.core.serviceimpl;

import org.osgi.service.component.annotations.Component;

import com.aem.aemfeb.core.service.AjaxSlingServletI;

@Component(service=AjaxSlingServletI.class,immediate=true)
public class AjaxSsImpl implements AjaxSlingServletI{

	@Override
	public String getEmployDetails() {
		
		try {
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return "welcome Aem ";
	}


	
	
	
	

}
