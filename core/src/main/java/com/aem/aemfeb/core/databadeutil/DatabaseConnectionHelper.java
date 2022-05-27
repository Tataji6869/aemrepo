package com.aem.aemfeb.core.databadeutil;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.commons.datasource.poolservice.DataSourcePool;
@Component(immediate=true,service=DatabaseConnectionHelper.class)
public class DatabaseConnectionHelper {
	
	private static final Logger log = LoggerFactory.getLogger(DatabaseConnectionHelper.class);
	  
@Reference
private DataSourcePool datasourceservice;
//
 public Connection getDataBaseConnection(String datasourcename) {
	 
	 
	 log.info("get data base sssstarted");
	 Connection con=null;
	 
	try {
		
		
DataSource datasource=(DataSource)datasourceservice.getDataSource(datasourcename);
  con=datasource.getConnection();
  
	}catch(Exception e) {
		
		//StringWriter sw= new StringWriter();
		//e.printStackTrace(new PrintWriter(sw));
		//log.error(sw.toString());
		log.error("Exception "+e.getMessage());

	}
	return con;
 }
}
