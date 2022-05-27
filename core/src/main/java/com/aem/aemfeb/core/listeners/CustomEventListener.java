package com.aem.aemfeb.core.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service=EventListener.class,immediate=true)
public class CustomEventListener implements EventListener {
	
	
	private static final Logger  log = LoggerFactory.getLogger(CustomEventListener.class);

	@Reference
	private ResourceResolverFactory resourceResolver;
	
	private ResourceResolver resolver;
	@Reference
	private SlingRepository repository;
	
	private Session session;
	
	@Activate
	protected void activated(ComponentContext componentContext) {
		log.info("Activating the observation");
		
		try {
			
			Map<String,Object>params= new HashMap<>();
			
			params.put(ResourceResolverFactory.SUBSERVICE,"some");
			
			resolver = resourceResolver.getServiceResourceResolver(params);
			
		session =resolver.adaptTo(Session.class);
		
		log.info("session created");
		
		session.getWorkspace().getObservationManager().addEventListener(this,Event.PROPERTY_ADDED|Event.NODE_ADDED,"/content/aemfeb/en",true, null, null, false);
		
		}catch (Exception e) {
		
			log.error(e.getMessage(),e);
				
		}
	}
	@Deactivate
	protected void deactivate() {
		
		if (session!=null) {
			session.logout();
			}
		}
	

	@Override
	public void onEvent(EventIterator events) {
		// TODO Auto-generated method stub
		
			
			try {
				
				
				while(events.hasNext()) {
					
	log.info("something has been added:{}",events.nextEvent().getPath());
				}

	       }catch (Exception e) {
	    	   
	       log.info("Exception occured",e);
	       }
	       }
			
			
		}
		
		
