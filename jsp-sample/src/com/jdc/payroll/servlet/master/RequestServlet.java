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
import com.jdc.payroll.db.entity.Request;

@WebServlet({ "/request-add", "/request-save", "/request-edit",
		"/request-index" })
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/payroll")
	private DataSource ds;
	private Model<Request> RequestModel;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.initResource();

		request.setAttribute("list", RequestModel.getAll());
		request.getRequestDispatcher("/view/master/request.jsp").forward(
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

			RequestModel.create(r);

			break;

		case "/request-save":

			break;

		default:
			break;
		}

		request.setAttribute("list", RequestModel.getAll());
		request.getRequestDispatcher("/view/master/request.jsp").forward(
				request, response);
	}

	private void initResource() {
		InputStream dbConfig = getServletContext().getResourceAsStream(
				"/WEB-INF/database.properties");
		RequestModel = Model.getModel(Request.class, Request::convert, ds,
				dbConfig);
	}

}
