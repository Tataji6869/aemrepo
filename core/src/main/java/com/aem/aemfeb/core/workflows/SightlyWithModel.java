package com.aem.aemfeb.core.workflows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables=Resource.class)
public class SightlyWithModel {
	
	@ValueMapValue
	@Default(values="AEM")
	private String authorName;

	@ValueMapValue
	private List<String>books;
	

  
    public String getAuthorName() {
        return authorName;
    }

    
    public List<String> getAuthorBooks() {
        if(books!=null){
            return new ArrayList<String>(books);
        }else{
            return Collections.emptyList();
        }
    }
}
