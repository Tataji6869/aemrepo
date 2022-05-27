/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.aem.aemfeb.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.settings.SlingSettingsService;

@Model(adaptables=Resource.class)
public class UserModel {




    @Inject @Default(values ="Enter your adress")
    private String add;
    
    @Inject @Default(values ="Enter your fastnamename")
    private String fname;
    
    
    
    
    @Inject @Default(values ="Enter your secondname")
    private String sname;
    
    @PostConstruct
    protected void init() {
       
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


}
