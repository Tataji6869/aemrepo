package com.aem.aemfeb.core.october;


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

@Component(service = Servlet.class,

property= {
		 Constants.SERVICE_DESCRIPTION +"=Myfirsts Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/happy/thisss"
		
}
)
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

				log.info("----------< Processing starts >----------");

				/**
				 * Getting the instance of resource resolver
				 */
				ResourceResolver resourceResolver = request.getResourceResolver();

				/**
				 * Getting the resource which has the data stored
				 */
				Resource resource = resourceResolver
						.getResource("/content/Augustpractic2/jcr:content/parcontent/octobersevletwithmod");

				/**
				 * Adapting the resource to the UserModel class
				 */
				UserModel model = resource.adaptTo(UserModel.class);

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


