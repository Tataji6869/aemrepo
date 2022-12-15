package com.aem.aemfeb.core.october;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
@Component(service=Servlet.class,
property= {
				 Constants.SERVICE_DESCRIPTION +"=Myfirsts Servlet",
                 "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                 "sling.servlet.paths=" + "/bin/happy/this"
				
		}
	)

public class OctoberServlet extends SlingSafeMethodsServlet  {
	@Override
	protected void doGet(final SlingHttpServletRequest req,final SlingHttpServletResponse mouse)throws ServletException,IOException{
		
		final Resource resource = req.getResource();
		mouse.setContentType("text/plain");
		
		mouse.getWriter().write("This is the octoberssservlet123456789");
		
	}
	
	
	

}
