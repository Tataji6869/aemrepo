package com.aem.aemfeb.core.serviceimpl;

import org.osgi.service.component.annotations.Component;


import com.aem.aemfeb.core.service.ReadJsonServiceI;
import com.aem.aemfeb.core.service.RestFinalNetwork;
import com.aem.aemfeb.core.service.RestfulAppConstant;

@Component(service=ReadJsonServiceI.class,immediate=true)
public class ReadJsonDataImpl implements ReadJsonServiceI{

	@Override
	public String getData() {
		
	String response =  RestFinalNetwork.readJson(RestfulAppConstant.URL);
		
		return response;
	}

}


	
	
	
	


