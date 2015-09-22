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
import com.jdc.payroll.db.entity.Leave;

@WebServlet({ "/leave-add", "/leave-save", "/leave-edit", "/leave-index" })
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/payroll")
	private DataSource ds;
	private Model<Leave> leaveModel;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.initResource();

		request.setAttribute("list", leaveModel.getAll());
		request.getRequestDispatcher("view/master/leave.jsp").forward(request,
				response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.initResource();

		String leave_type = request.getParameter("leave_type");
		String leave_days = request.getParameter("leave_days");
		String description = request.getParameter("description");

		switch (request.getServletPath()) {
		case "/leave-add":

			Leave l = new Leave();
			l.setLeave_type(leave_type);
			l.setLeave_days(Float.parseFloat(leave_days)); // Conver String to
															// Float
			l.setDescription(description);

			leaveModel.create(l);

		case "/leave-save":

			break;

		default:
			break;
		}

		request.setAttribute("list", leaveModel.getAll());
		request.getRequestDispatcher("/view/master/leave.jsp").forward(
				request, response);

	}

	private void initResource() {
		InputStream dbConfig = getServletContext().getResourceAsStream(
				"/WEB-INF/database.properties");
		leaveModel = Model.getModel(Leave.class, Leave::convert, ds, dbConfig);
	}

}
