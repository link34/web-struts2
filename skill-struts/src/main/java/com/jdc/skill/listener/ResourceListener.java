package com.jdc.skill.listener;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Application Lifecycle Listener implementation class DatasourceListener
 *
 */
@WebListener
public class ResourceListener implements ServletContextListener {
	
	@Resource(name="jdbc/skill_db")
	private DataSource ds;

    /**
     * Default constructor. 
     */
    public ResourceListener() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("Datasource", ds);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
	
}
