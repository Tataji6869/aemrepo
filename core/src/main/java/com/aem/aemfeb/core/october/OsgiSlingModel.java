package com.aem.aemfeb.core.october;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import com.aem.aemfeb.core.october.OsgiServiceInterface;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OsgiSlingModel {
	

	@Inject
	private String raj;
	@OSGiService(filter="(component.name=com.aem.aemfeb.core.october.Osgi2)")

	private OsgiServiceInterface obj;
	@Inject
	private String tataji;

	public String getRaj() {
		return raj;
	}

	public String getTataji() {
		return tataji;
	}

	@PostConstruct
	public String getStudentDetails() {

		String name = obj.getEmployDetails(); // TODO Auto-generated method stub return
		return name;
	}
}
