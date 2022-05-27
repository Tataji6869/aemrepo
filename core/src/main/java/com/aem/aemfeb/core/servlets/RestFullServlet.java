/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aem.aemfeb.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.resource.ValueMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;




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
import com.aem.aemfeb.core.service.AjaxSlingServletI;
import com.aem.aemfeb.core.service.ReadJsonServiceI;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Sling Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/RestFullServlet" })
public class RestFullServlet extends SlingAllMethodsServlet {
	
	


	/**
	 * Generated serialVersionUID
	 */
	private static final long serialVersionUID = 7558680464517017317L;
	
	/**
	 * Logger
	 */
	private static final Logger log = LoggerFactory.getLogger(RestFullServlet.class);
	  
	
	
	@Reference
	private ReadJsonServiceI  service;
	

	/**
	 * Overridden method
	 */
	
	@Override
    protected void doPost(SlingHttpServletRequest request,SlingHttpServletResponse response)
    {
	   try {
       String  restfull = service.getData();
			log.info("----------< Processing starts >----------"+service);
			/**
			
			 * Adapting the resource to the UserModel class
			 */
		
			response.setContentType("text/plain");
			response.getWriter().write(restfull);
		} catch (Exception e) {

			log.error(e.getMessage(), e);
		}

	}

}