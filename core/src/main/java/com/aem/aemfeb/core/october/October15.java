package com.aem.aemfeb.core.october;


import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class)
public class October15 {
	@Inject
	private String AA;
	@Inject
	private String BB;
	@Inject
	private String CC;

	public String getA() {
		return AA;
	}

	public String getB() {
		return BB;
	}

	public String getC() {
		return CC;
	}
	
	
	

}
