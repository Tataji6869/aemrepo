package com.aem.aemfeb.core.october;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component (service=Servlet.class,
    property= {Constants.SERVICE_DESCRIPTION +"=octoberresoursetype",
    		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
    		"sling.servlet.resourceTypes="+ "aemfeb/components/structure/page",
    		"sling.servlet.extensions="+  "txt"})

public class OctoberServletResourceType extends SlingAllMethodsServlet{

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		final Resource resource = request.getResource();
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		response.getWriter().write("this the resoursetypeservlet resgisterded123456789");
		
	}
	
	
	
}

