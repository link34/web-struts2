package com.jdc.payroll.servlet.master;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.jdc.db.Model;
import com.jdc.payroll.db.entity.Position;

@WebServlet({ 
		"/position-add", 
		"/position-save",
		"/position-edit", 
		"/position-index" })
public class PositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/payroll")
	private DataSource ds; 
	private Model<Position> positionModel;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.initResource();
		
		request.setAttribute("list", positionModel.getAll());
		request.getRequestDispatcher("/view/master/position.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.initResource();
		
		String pCode = request.getParameter("postion-code");
		String description = request.getParameter("description");
		
		switch (request.getServletPath()) {
		case "/position-add":
			
			Position p = new Position();
			p.setPosition_cd(pCode);
			p.setDescription(description);
			
			positionModel.create(p);
			
			break;

		case "/position-save":
			
			break;

		default:
			break;
		}

		request.setAttribute("list", positionModel.getAll());
		request.getRequestDispatcher("/view/master/position.jsp").forward(request, response);
	}
	
	private void initResource() {
		InputStream dbConfig = getServletContext().getResourceAsStream("/WEB-INF/database.properties");
		positionModel = Model.getModel(Position.class, Position::convert, ds, dbConfig);
	}

}
