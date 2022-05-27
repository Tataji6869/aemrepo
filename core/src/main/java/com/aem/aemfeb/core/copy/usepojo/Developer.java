package com.aem.aemfeb.core.copy.usepojo;

import com.adobe.cq.sightly.WCMUsePojo;
import com.aem.aemfeb.core.service.SightlyServiceInterface;

public class Developer extends WCMUsePojo{
	private String details;

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
SightlyServiceInterface service = getSlingScriptHelper().getService(SightlyServiceInterface.class);
	 details = service.getDeveloperData();
	}
	
		
	
public String getDetails() {
	return this.details;


}
}
