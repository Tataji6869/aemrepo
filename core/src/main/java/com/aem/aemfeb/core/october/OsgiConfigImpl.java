package com.aem.aemfeb.core.october;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

@Component(service=OsigiCongigInterface.class,immediate=true)
@Designate(ocd = NewOsgiConfiguration.class)// osgiconfiguration
public class OsgiConfigImpl implements OsigiCongigInterface{
	
	
	
	private String serviceName;
	private int serviceCount;
	private boolean liveData;
	private String[] countries;
	
	
	@Activate
	public void activate(NewOsgiConfiguration serviceconfig) {
		
		serviceName=serviceconfig.serviceName();
		serviceCount=serviceconfig.getServiceCount();
		liveData=serviceconfig.getLiveData();
		countries=serviceconfig.getCountry();	
}
		
		
	

	@Override
	public String getServiceName() {
		// TODO Auto-generated method stub
		return serviceName;
	}

	@Override
	public int getServiceCount() {
		// TODO Auto-generated method stub
		return serviceCount;
	}

	@Override
	public boolean isLiveData() {
		// TODO Auto-generated method stub
		return liveData;
	}

	@Override
	public String[] getCountries() {
		// TODO Auto-generated method stub
		return countries;
	}


	}

