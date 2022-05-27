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
public class UserModeladdservlet {




    @Inject @Default(values ="Enter your fastname")
    private String firstName;
    
    @Inject @Default(values ="Enter your lastname")
    private String lastName;
    
    
    
    
    @Inject @Default(values ="Enter your gender")
    private String gender;
    
    @Inject @Default(values ="Enter your country")
    private String country;
    
    @PostConstruct
    protected void init() {
       
    }
    
    public String getFirstName() {
        return firstName;
    }

    
    public String getLastName() {
        return lastName;
    }
   
    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

}
