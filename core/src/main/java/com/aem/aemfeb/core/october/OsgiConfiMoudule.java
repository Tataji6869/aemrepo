package com.aem.aemfeb.core.october;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="bhimavaram Aem",description="Aem hyderabad")
public @interface OsgiConfiMoudule {
	

	@AttributeDefinition(name="ServiceId",description="Bhimavaram description",
			type=AttributeType.INTEGER)
	
	int bhiamvaramId();
	
	@AttributeDefinition(name="Bhimavaram",description="IN bhimavcaram vishnu education",
			type=AttributeType.STRING)
	String bhimavaramName()default "Bhimavaramm mutliplex";
	
	
	@AttributeDefinition(name="which district in bhimavaram",description=" plese enter the bhimavaram which district",
			                          
			              type=AttributeType.STRING)

	String districtHeadquters();

}
