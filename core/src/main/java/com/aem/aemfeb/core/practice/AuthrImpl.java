package com.aem.aemfeb.core.practice;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Required;

@Model(adaptables=Resource.class,
     adapters=AuthorI.class,
    defaultInjectionStrategy =DefaultInjectionStrategy.OPTIONAL
    )
public class AuthrImpl implements AuthorI {
	
	
	@Inject
	@Default(values="Aem")
	
	String fName;
	
	@Inject
	@Default(values="Greekssss")
	String lName;

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return fName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lName;
	}

}
