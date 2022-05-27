package com.aem.aemfeb.core.servlets;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aemfeb.core.service.EmployI;


@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Sling Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/OsgiServiceServlets" })
public class OsgiServiceServlets extends SlingSafeMethodsServlet {
	
	

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 7558680464517017317L;
	
	/**
	 * Logger
	 */
	private static final Logger log = LoggerFactory.getLogger(OsgiServiceServlets.class);
	
	/**
	 * Overridden method
	 */
	@Reference
	  private EmployI obj;
	
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

		try {
     String name =obj.getEmployDetails();
			log.info("----------< Processing starts >----------"+name);
			response.setContentType("text/plain");
			response.getWriter().write("Name........"+name);
			
		} catch (Exception e) {

			log.error(e.getMessage(), e);
		}

	}

}
 