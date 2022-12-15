package com.aem.aemfeb.core.october;

import java.io.IOException;

import javax.servlet.Servlet;
import org.osgi.framework.Constants;
import org.apache.sling.api.SlingException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(service=Servlet.class,
     property = {
    		Constants.SERVICE_DESCRIPTION +"=Myfirsts Servlet",
             "sling.servlet.methods=" + HttpConstants.METHOD_GET,
             "sling.servlet.paths=" + "/bin/osgiservlet"
			
    		 
     }
		
		)
public class Osgi1toServlet extends SlingAllMethodsServlet {
	
	@Reference
	private OsgiServiceInterface obj;
		// TODO Auto-generated constructor stub
	
	
	
	protected void doGet(final SlingHttpServletRequest x,final SlingHttpServletResponse Y) throws SlingException,IOException{
		  
	String name=	obj.getEmployDetails();
		
		Y.setContentType("text/plain");
		Y.getWriter().write("THIS IS THE OSGI SERVICE"+name);
		
		
		
	}

}
