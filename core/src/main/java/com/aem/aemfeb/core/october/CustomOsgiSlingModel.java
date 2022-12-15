package com.aem.aemfeb.core.october;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
@Model(adaptables=SlingHttpServletRequest.class)
public class CustomOsgiSlingModel {
	
	
	@OSGiService
	OsigiCongigInterface   osgiconfig;

	
	public String getServiceName() {
		// TODO Auto-generated method stub
		return osgiconfig.getServiceName();
	}

	 public int getServiceCount() {
		// TODO Auto-generated method stub
		return osgiconfig.getServiceCount();
	}


	public boolean isLiveData() {
		// TODO Auto-generated method stub
		return osgiconfig.isLiveData();
	}

	
	public String[] getCountries() {
		// TODO Auto-generated method stub
		return osgiconfig.getCountries();
	}

}
