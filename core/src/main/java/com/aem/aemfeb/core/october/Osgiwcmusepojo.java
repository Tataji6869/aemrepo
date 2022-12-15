package com.aem.aemfeb.core.october;

import org.apache.sling.api.scripting.SlingScriptHelper;

import com.adobe.cq.sightly.WCMUsePojo;

public class Osgiwcmusepojo extends WCMUsePojo {

	
   private String detail;

	@Override
	public void activate() throws Exception {
		 OsgiServiceInterface service = getSlingScriptHelper().getService(OsgiServiceInterface.class);
		 
		 
		detail = service.getEmployDetails();
		
	}
	public String getDetails() {

	    return this.detail;

	  }

}
