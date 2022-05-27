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
import com.aem.aemfeb.core.service.NodeInterFaceI;


@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Sling Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/NodeValulueCreationsu" })
public class NodeValulueCreationsu extends SlingSafeMethodsServlet {
	
	

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 7558680464517017317L;
	
	/**
	 * Logger
	 */
	private static final Logger log = LoggerFactory.getLogger(NodeValulueCreationsu.class);
	
	/**
	 * Overridden method
	 */
	@Reference
	  private NodeInterFaceI obj;
	
	
	@Override
	protected void doGet(SlingHttpServletRequest req, SlingHttpServletResponse response) {

		try {
    //
			log.info("----------< Processing starts >----------");
			
			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String userName = req.getParameter("userName");
			String passWord = req.getParameter("passWord");
			 boolean b=obj.registerEmployDetails(firstName, lastName, userName, passWord);
			response.setContentType("text/plain");
			response.getWriter().write("Name........");
			
		} catch (Exception e) {

			log.error(e.getMessage(), e);
		}

	}

}
 