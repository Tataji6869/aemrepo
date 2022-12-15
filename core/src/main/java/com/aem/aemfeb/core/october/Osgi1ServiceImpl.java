package com.aem.aemfeb.core.october;

import org.osgi.service.component.annotations.Component;

@Component(service=OsgiServiceInterface.class)
public class Osgi1ServiceImpl implements OsgiServiceInterface {

	@Override
	public String getEmployDetails() {
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return "WELCOME";
	}

}
