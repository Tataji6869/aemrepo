package com.aem.aemfeb.core.october;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Required;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;



@Model(adaptables= SlingHttpServletRequest.class,
defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class Ajayanna {
	
	
	@ScriptVariable
	Page currentPage;
	
	@SlingObject
	ResourceResolver resourse;
	
	 @ChildResource(name="october")
	    Resource child;
	
	@Self
	SlingHttpServletRequest singHttpServlet;
	
	@OSGiService
	QueryBuilder queyBuilder;
	
	@Inject
	@Via("resource")
	@Named("jcr:lastModifiedBy")
	private String names;
	
	
	@RequestAttribute(name="rAttribute")
	private String apple;
	
	@ResourcePath(path = "/content/aemfeb/en/test-")
	@Via("resource")
	Resource reso;
	
	
	@Inject
	@Via("resource")
	@Default(values="banana")
	private String raj;
	
    @ValueMapValue
	@Default(values="grapes")
	private String deepak;
	
	@Inject 
	@Via("resource")
	@Default(values="apples")
	private String tataji;
	
	@Inject
	private boolean dev;
	
	
	@PostConstruct
	private void happy(){
	raj="AemDeveloper";
	}
	
	@PostConstruct
	private void happy1(){
	deepak="AemDeveloper";
		
		
	}
	   public String getChildPath() {
		      return  child.getName();
		    }
	

	public String getRajshekar() {
		// TODO Auto-generated method stub
		return raj;
	}

	public String getDeepak() {
		// TODO Auto-generated method stub
		return deepak;
	}

	public String getTataji() {
		// TODO Auto-generated method stub
		return tataji;
	}

	public String getRequestAttribute() {
		// TODO Auto-generated method stub
		return apple;
	}


	public boolean getAemDevelopers() {
		// TODO Auto-generated method stub
		return dev;
	}
	public String getPageTitle() {
		// TODO Auto-generated method stub
		return currentPage.getTitle();
}
	public String getHomeResourceName() {
		// TODO Auto-generated method stub
		return reso.getName();
}
	public String getModified() {
		// TODO Auto-generated method stub
		return names;
}
}
