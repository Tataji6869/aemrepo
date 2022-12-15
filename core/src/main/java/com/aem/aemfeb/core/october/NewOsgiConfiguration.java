package com.aem.aemfeb.core.october;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.osgi.service.metatype.annotations.Option;

@ObjectClassDefinition(name="DeWalli--- Configuration",
  description="New OsgiConguration Dewali")

public @interface NewOsgiConfiguration {
	
	
	
	 @AttributeDefinition(name="Service Name",
			  description="Enter the DewaliName",
			  type=AttributeType.STRING)
	public String serviceName() default" what is the dervice name ";
	 
	 
	 
	 @AttributeDefinition(name="Service Count",
			 description="how many Crachers sale",
			 type=AttributeType.INTEGER)
	 
	 public int getServiceCount()default 5;
	 
	 @AttributeDefinition( name = "Live Data",
			 description="how many Crachers sale",
			 type=AttributeType.BOOLEAN)
	 boolean getLiveData()default false;
	 
	 @AttributeDefinition(name = "Countries",
             description = "Add countries locales for which you want to run this service.",
             type = AttributeType.STRING)
	 
	 String[] getCountry() default {"india","America"};
	 

     @AttributeDefinition(
             name = "Run Modes",
             description = "Select Run Mode.",
             options = {
                    @Option(label = "Author",value = "author"),
                    @Option(label = "Publish",value = "publish"),
                    @Option(label = "Both",value = "both")
             },
             type = AttributeType.STRING)
     String getRunMode() default "both";
 }
	 

 


	 		
	 		
			
	 
	 

