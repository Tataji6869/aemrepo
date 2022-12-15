package com.aem.aemfeb.core.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
@Model(adaptables=SlingHttpServletRequest.class,
        adapters =MultiInterface.class,
        defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class MultipleImpl implements MultiInterface{
	@Inject
	Resource apple;
	
	@ValueMapValue
	private String authorName;
	
	
	@ValueMapValue
	@Default (values="AEM")
	private List <String>books;
	
	

	@Override
	public String getAuthorName() {
		
		
		return authorName;
	}

	@Override
	public List<String> getAuthorBooks() {
		if (books!=null) {
			
			return new ArrayList<String>(books);
		}else {
		return Collections.emptyList();
	}

}
}
