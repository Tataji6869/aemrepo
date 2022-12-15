package com.aem.aemfeb.core.october;

import org.osgi.service.component.annotations.Component;

@Component(service=AjaxInterface.class,immediate=true)// this annotation is used called Osgi service
public class AjaxOsgiService implements AjaxInterface{

	@Override
	public String getCallingAjax() {
		// TODO Auto-generated method stub
		return "today is October18 so thursday date 2022";
	}

}
