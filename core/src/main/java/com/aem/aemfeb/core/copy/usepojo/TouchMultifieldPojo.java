package com.aem.aemfeb.core.copy.usepojo;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;


public class TouchMultifieldPojo extends WCMUsePojo {
	private static final Logger log = LoggerFactory.getLogger(TouchMultifieldPojo.class);
	  
	
	private HashMap<String,String> links=new HashMap<>();

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		String linkpath[]=getProperties().get("linkpath",String[].class);
		String linktitle[]=getProperties().get("linktitle",String[].class);
		
		for(int i=0;i<linktitle.length;i++){
		        links.put(linktitle[i],linkpath[i]);
		}
	
		
	}
	public HashMap<String,String>getLinks(){
		 log.info("get data base sssstarted"+links);
		return links;
		
		
		
	}
}
