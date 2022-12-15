package com.aem.aemfeb.core.october;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = Oct17OsgiInterface.class, immediate = true)
public class Oct17OsgiImpl implements Oct17OsgiInterface {

	private static final Logger log = LoggerFactory.getLogger(Oct17OsgiInterface.class);
	
	@Reference
	private ResourceResolverFactory resolverFactory;
	

	@Override
	public Iterator<Page> getPage() {

		try {
			
			log.info("-----------------resourseresolver------------");

			ResourceResolver resourceResolver = resolverFactory.getResourceResolver(getSubService());
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

			Page page = pageManager.getPage("/content/aemfeb/en");
			Iterator<Page> pages = page.listChildren();
			log.info("-----------------resourseresolver------------"+pages);
			return pages;

		} catch (Exception e) {
			// TODO: handle exception
		}

		// TODO Auto-generated method stub
		return null;
	}
	public Map<String, Object> getSubService() {
		log.info("inside getSubService method");
		Map<String, Object> serviceMap = null;
		try {

			serviceMap = new HashMap<String, Object>();

			serviceMap.put(ResourceResolverFactory.SUBSERVICE, "aemfeb");

		} catch (Exception e) {

			log.error("Exception " + e.getMessage());

		}
		log.info("getSubService method ended");

		log.info(serviceMap.toString());

		return serviceMap;
	}

}
