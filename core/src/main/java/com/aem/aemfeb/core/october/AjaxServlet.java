package com.aem.aemfeb.core.october;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(service=Servlet.class,
  property= { Constants.SERVICE_DESCRIPTION +"=octoberresoursetype",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET,
		"sling.servlet.paths="+ "/bin/ajaxcalling/osgitoServlet"})
		  

public class AjaxServlet extends SlingAllMethodsServlet {
	
	@Reference
	private AjaxInterface  obj;
	

	
	protected void doGet(final SlingHttpServletRequest request,final SlingHttpServletResponse response)
			throws ServletException,IOException{
		
		String osgiajaxdata = obj.getCallingAjax();
	
	response.setContentType("text/plain");
	
	response.getWriter().write(osgiajaxdata);
	
}
	

}
