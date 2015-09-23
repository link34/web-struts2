package com.jdc.payroll.servlet.master;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.jdc.db.Model;
import com.jdc.db.Param;
import com.jdc.payroll.db.entity.Request;

@WebServlet({ "/request-add", 
	"/request-save", 
	"/request-edit",
	"/request-delete",
	"/request-index" })
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/payroll")
	private DataSource ds;
	private Model<Request> requestModel;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.initResource();
		
		
		String id = request.getParameter("id");
		String jsp = "/view/master/request.jsp";
		
		switch (request.getServletPath()) {
		case "/request-edit":
			
			Request req = requestModel.findById(Param.getInstance().put("id", Integer.parseInt(id)));
			request.setAttribute("request", req);
			jsp = "/view/master/request-edit.jsp";
			break;

		case "/request-delete":
			
			requestModel.delete("id = ?", Arrays.asList(Integer.parseInt(id)));
			request.setAttribute("list", requestModel.getAll());
			break;

		default:
			request.setAttribute("list", requestModel.getAll());
			break;
		}		

		request.getRequestDispatcher(jsp).forward(
				request, response);
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.initResource();

		
		String reqname = request.getParameter("name");
		String reqtype = request.getParameter("type");
	
		switch (request.getServletPath()) {
		case "/request-add":

			Request r = new Request();
			r.setName(reqname);
			r.setType(reqtype);

			requestModel.create(r);

			break;

		case "/request-save":
			String id = request.getParameter("id");
			requestModel.update("name=?", "id=?", Arrays.asList(reqname, Integer.parseInt(id)));
			requestModel.update("type=?", "id=?", Arrays.asList(reqtype, Integer.parseInt(id)));
			break;

		default:
			break;
		}

		request.setAttribute("list", requestModel.getAll());
		request.getRequestDispatcher("/view/master/request.jsp").forward(
				request, response);
	}

	private void initResource() {
		InputStream dbConfig = getServletContext().getResourceAsStream(
				"/WEB-INF/database.properties");
		requestModel = Model.getModel(Request.class, Request::convert, ds,
				dbConfig);
		
		
	}

}
