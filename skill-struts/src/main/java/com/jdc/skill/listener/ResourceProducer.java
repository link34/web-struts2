package com.jdc.skill.listener;

import java.io.InputStream;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

@ApplicationScoped
public class ResourceProducer {


	@Produces
	@DbResourse
	public DataSource getDataSource() {

		Map<String, Object> application = ActionContext.getContext()
				.getApplication();
		return (DataSource) application.get("Datasource");
	}

	@Produces
	@DbConfiguration
	public InputStream getConfiguration() {
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/WEB-INF/database.properties");
	}
	
}
