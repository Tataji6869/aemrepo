package com.aem.aemfeb.core.workflows;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.version.VersionException;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component( service = WorkflowProcess.class,
property = { "process.label=" + "Adding property"
})
public class Workflowss implements WorkflowProcess{
    
	@Reference
	ResourceResolverFactory rrf;
	
	@Override
	public void execute(WorkItem workItem, WorkflowSession workSession, MetaDataMap metaData) throws WorkflowException {
		// TODO Auto-generated method stub
      WorkflowData workData = workItem.getWorkflowData();
	  String payload = workData.getPayload().toString()+"/jcr:content";
	  
	 Map<String,Object> map=new HashMap<String,Object>();
     map.put(rrf.SUBSERVICE, "latest");
     
     try {
		ResourceResolver rr=rrf.getServiceResourceResolver(map);
		//Resource resource =  (Resource) rr.getResource(payload);
		Resource resource = rr.getResource(payload);
         
		Node node1 = resource.adaptTo(Node.class);
		Node node2 = resource.adaptTo(Node.class);
		node1.addNode("addingNode").setPrimaryType("cq:PageContent");
		node1.addNode("tataji").setPrimaryType("cq:PageContent");
		node1.setProperty("city", "America");

	     rr.adaptTo(Session.class).save();
	     
				
	} catch (LoginException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (NoSuchNodeTypeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (VersionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ConstraintViolationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (LockException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ItemExistsException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (PathNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (RepositoryException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
}
}
