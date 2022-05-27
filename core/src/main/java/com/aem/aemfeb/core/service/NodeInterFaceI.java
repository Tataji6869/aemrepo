package com.aem.aemfeb.core.service;

import java.util.Map;

public interface NodeInterFaceI {
	public boolean registerEmployDetails(String firstName,String lastName,String userName,String passWord);
    public boolean loginEmployee(String user,String pass);
    public Map<String,Object> getSubService();
    
}
