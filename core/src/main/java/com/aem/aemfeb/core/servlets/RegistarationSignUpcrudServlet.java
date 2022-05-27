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

import com.aem.aemfeb.core.service.SignUpCrudInterFaceI;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


@Component(service=Servlet.class,
           property={
                   Constants.SERVICE_DESCRIPTION + "=MyMySecondServlet Servlet",
                   "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                   "sling.servlet.paths=" +"/bin/RegistarationSignUpcrudServlet"
                
                   
           })
public class RegistarationSignUpcrudServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUid = 1L;

  @Reference
  private SignUpCrudInterFaceI signupobj;
 
    @Override
    protected void doGet(SlingHttpServletRequest request,SlingHttpServletResponse response)
    		throws ServletException, IOException {
    	
    	//super.doPost(request,response);
    	String name=request.getParameter("name");
    	String email=request.getParameter("email");
    	String age=request.getParameter("age");
    	String weight=request.getParameter("weight");
    	signupobj.registerEmployeeDetails(name, email, age, weight);
    	
    	response.setContentType("text/plain");
    	PrintWriter out = response.getWriter();
    	out.print("<table border='1' width='100%'");
    	out.print(
				"<tr><th> Name</th><th>Age</th><th>Email</th><th>Weight</th></tr>");
    	out.print("</table>");
    	//response.getWriter().write(".......YOUR ENTERD DETAILS. SIGN UP DETAILS..........");
    	//response.getWriter().write("sighup................."+name);
    	//response.getWriter().write("sighup..............."+email);
    	//response.getWriter().write("sighup............... "+age);
    	//response.getWriter().write("sighup............... "+weight);
    	
    }
}
