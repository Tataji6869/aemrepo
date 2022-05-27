
package com.aem.aemfeb.core.servlets;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aemfeb.core.models.UserModeladdservlet;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Sling Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/SlingModelServlet" })
public class SlingModelServlet extends SlingSafeMethodsServlet {

	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 7558680464517017317L;
	
	/**
	 * Logger
	 */
	private static final Logger log = LoggerFactory.getLogger(SlingModelServlet.class);
	
	/**
	 * Overridden method
	 */
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

		try {

			
			/**
			 * Getting the instance of resource resolver
			 */
			ResourceResolver resourceResolver = request.getResourceResolver();
			log.info("----------< Processing starts >----------");

			/**
			 * Getting the resource which has the data stored
			 */
			Resource resource = resourceResolver
					.getResource("/content/aemfirstpage/user/jcr:content/parcontent/employees");
			
			log.info("----------< rajshekar >----------");

			/**
			 * Adapting the resource to the UserModel class
			 */
			UserModeladdservlet model = resource.adaptTo(UserModeladdservlet.class);

			/**
			 * Printing the value stored on the browser window
			 */
			response.getWriter()
					.print("Data stored in the resource is:\nFirst Name: " + model.getFirstName() + "\nLast Name: "
							+ model.getLastName() + "\nGender: " + model.getGender() + "\nCountry: "
							+ model.getCountry());
			
			/**
			 * Closing the resource resolver
			 */
			resourceResolver.close();

		} catch (Exception e) {

			log.error(e.getMessage(), e);
		}

	}

}