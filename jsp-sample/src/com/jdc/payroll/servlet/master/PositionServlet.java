package com.jdc.payroll.servlet.master;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import com.jdc.db.Model;
import com.jdc.db.Param;
import com.jdc.payroll.db.entity.Position;

@WebServlet({ 
		"/position-add", 
		"/position-save",
		"/position-upload",
		"/position-edit", 
		"/position-delete", 
		"/position-index" })
@MultipartConfig
public class PositionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/payroll")
	private DataSource ds; 
	private Model<Position> positionModel;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.initResource();

		String pCode = request.getParameter("id");
		String jsp = "/view/master/position.jsp";
		
		switch (request.getServletPath()) {
		case "/position-edit":
			
			Position position = positionModel.findById(Param.getInstance().put("position_cd", pCode));
			request.setAttribute("position", position);
			jsp = "/view/master/position-edit.jsp";
			break;

		case "/position-delete":
			
			positionModel.delete("position_cd = ?", Arrays.asList(pCode));
			request.setAttribute("list", positionModel.getAll());
			break;

		default:
			request.setAttribute("list", positionModel.getAll());
			break;
		}		

		request.getRequestDispatcher(jsp).forward(request, response);
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
			positionModel.update("description=?", "position_cd=?", Arrays.asList(description, pCode));
			break;
			
		case "/position-upload":	
			Part part = request.getPart("positionFile");
			if(part != null) {
				
				try (InputStream in = part.getInputStream();
						BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
					
					String line = null;
					
					while(null != (line = br.readLine())) {
						
						String [] strs = line.split("\t");
						
						Position posit = new Position();
						posit.setPosition_cd(strs[0]);
						posit.setDescription(strs[1]);
						
						positionModel.create(posit);
					}
					
				} catch (Exception e) {
					
				}
			}
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
