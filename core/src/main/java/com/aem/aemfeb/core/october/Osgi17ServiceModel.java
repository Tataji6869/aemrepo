package com.aem.aemfeb.core.october;

import java.util.Iterator;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.day.cq.wcm.api.Page;

@Model(adaptables=SlingHttpServletRequest.class)
public class Osgi17ServiceModel {
	
	
	
	@OSGiService
	Oct17OsgiInterface  octService;
	
	
	public Iterator<Page> getPageDetails(){
		
		return octService.getPage();
		
		
		
	}


	
	
	
}
