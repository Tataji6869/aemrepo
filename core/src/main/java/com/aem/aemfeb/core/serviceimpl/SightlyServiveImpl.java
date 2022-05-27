package com.aem.aemfeb.core.serviceimpl;

import org.osgi.service.component.annotations.Component;


import com.aem.aemfeb.core.service.SightlyServiceInterface;
@Component(service=SightlyServiceInterface.class,immediate=true)
public class SightlyServiveImpl  implements SightlyServiceInterface{

	@Override
	public String getDeveloperName() {
		// TODO Auto-generated method stub
		return "Apple";
	}

	@Override
	public String getDeveloperProfile() {
		// TODO Auto-generated method stub
		return "Aem developer";
	}

	@Override
	public String getDeveloperSkills() {
		// TODO Auto-generated method stub
		return "java,Aem,sling,usepojo";
	}

	@Override
	public String getDeveloperData() {
	String name=	this.getDeveloperName();
	String profile=	this.getDeveloperProfile();
	String Skills=	this.getDeveloperSkills();
		// TODO Auto-generated method stub
		return name+"he is a"+profile+"he is expert in "+Skills;
	}

}