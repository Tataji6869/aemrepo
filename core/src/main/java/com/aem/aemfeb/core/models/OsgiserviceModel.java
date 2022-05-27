
package com.aem.aemfeb.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.settings.SlingSettingsService;

import com.aem.aemfeb.core.service.EmployI;




@Model(adaptables=Resource.class)
public class OsgiserviceModel {

@OSGiService
private EmployI Obj;


    private String name;


    @Inject @Default(values ="Enter your adress")
    private String add;
    
    @Inject @Default(values ="Enter your fastnamename")
    private String fname;
    
    
    
    
    @Inject @Default(values ="Enter your secondname")
    private String sname;
    
    @PostConstruct
    protected void init() {
    	name=Obj.getEmployDetails();
   
    }
    
    public String getAdd() {
        return add;
    }

    
    public String getFname() {
        return fname;
    }
   
    public String getSname() {
        return sname;
    }
    public String getName() {
        return name;
    }


}
