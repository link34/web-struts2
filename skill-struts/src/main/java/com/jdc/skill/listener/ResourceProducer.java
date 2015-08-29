package com.jdc.skill.listener;

import java.io.InputStream;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

@ApplicationScoped
public class ResourceProducer {
	
	@Resource(name="jdbc/skill_db")
	private DataSource datasource;
	
	@Inject
	private ServletContext servletContext;


	@Produces
	@DbResourse
	public DataSource getDatasource() {
		return datasource;
	}

	@Produces
	@DbConfiguration
	public InputStream getConfiguration() {
		return servletContext.getResourceAsStream("/WEB-INF/database.properties");
	}
	
}
