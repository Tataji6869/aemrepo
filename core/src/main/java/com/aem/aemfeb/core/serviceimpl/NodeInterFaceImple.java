package com.aem.aemfeb.core.serviceimpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.aem.aemfeb.core.service.NodeInterFaceI;
@Component(service=NodeInterFaceI.class,immediate=true)
public  class NodeInterFaceImple implements NodeInterFaceI {
	
	
	private static final Logger  log = LoggerFactory.getLogger(NodeInterFaceImple.class);
	@Reference
	private ResourceResolverFactory resolverfactorys; 
	
	ResourceResolver  resourceResolver=null;
	private Session session;
	
	Resource resource;
	
	String resourcePath="/content/aemfirstpage/user/jcr:content/employees";
	

	@Override
	public boolean registerEmployDetails(String firstName, String lastName, String userName, String passWord) {
		// TODO Auto-generated method stub
		
		boolean flag=false;
		try {
		log.info("register EmployeeDetails method Started");
		
		resourceResolver=resolverfactorys.getServiceResourceResolver(getSubService());
		
		resource  = resourceResolver.getResource(resourcePath);
		
		log.info("resourse--------------"+resource);

		//create random number.
		
		Random r= new Random();
		
		int low=10;
		
		int high =1000;
		
		int result =r.nextInt(high-low)+low;
		
		log.info("result**************"+result);
		
		String numbervalues="employees"+result;
		
		
		log.info("numbervalues-------------"+numbervalues);

		Node node=resource.adaptTo(Node.class);
	
		
		if (node!=null){
			log.info("inside if condition");
			Node empRoot =node.addNode(numbervalues,"nt:unstructured");
			
			log.info("emproott************"+empRoot);

			
			empRoot.setProperty("FirstName",firstName);
			empRoot.setProperty("LastName", lastName);
			empRoot.setProperty("UserName",userName);
			empRoot.setProperty("PassWord", passWord);
			session.save();
			flag=true;
		}
			}catch(Exception e) {
				log.info("exception"+e.getMessage());
			
				
			}finally {
				if(session!=null) {
				
					log.info("inside finally block");
					
					session.logout();
					
					
				}
			}
	log.info("RegisterEmployee Details  method");
		
		
		return flag;
	}

	@Override
	public boolean loginEmployee(String user, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getSubService() {
		log.info("inside getSubService method");
		Map<String, Object> serviceMap = null;
		try {

			serviceMap = new HashMap<String, Object>();

			serviceMap.put(ResourceResolverFactory.SUBSERVICE, "some");

		} catch (Exception e) {

			log.error("Exception " + e.getMessage());

		}
		log.info("getSubService method ended");

		log.info(serviceMap.toString());

		return serviceMap;
	}


}
