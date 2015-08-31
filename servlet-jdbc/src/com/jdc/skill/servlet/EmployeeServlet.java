package com.jdc.skill.servlet;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.jdc.skill.entity.Employee;
import com.jdc.skill.model.EmployeeModel;

@WebServlet({ "/createEmployee", "/employeeList" })
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EmployeeModel model;
	
	@Resource(name="jdbc/skill_db")
	private DataSource ds;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
		model = new EmployeeModel(ds);
		
		switch (servletPath) {
		case "/createEmployee":
			this.createEmployee(request, response);
			break;

		default:
			this.employeeList(request, response);
			break;
		}
		System.out.println(servletPath);
	}

	private void employeeList(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Employee> list = model.getAll();
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>Employee List</title>");
		sb.append("</head>");
		
		sb.append("<body>");

		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<th>Name</th>");
		sb.append("<th>Phone</th>");
		sb.append("<th>Email</th>");
		sb.append("<th>Address</th>");
		sb.append("</tr>");

		for(Employee e : list) {
			sb.append("<tr>");
			sb.append("<td>").append(e.getName()).append("</td>");
			sb.append("<td>").append(e.getPhone()).append("</td>");
			sb.append("<td>").append(e.getEmail()).append("</td>");
			sb.append("<td>").append(e.getAddress()).append("</td>");
			sb.append("</tr>");
		}

		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		response.getWriter().write(sb.toString());
	}
	
	private void createEmployee(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Employee emp = new Employee();
		emp.setName(request.getParameter("name"));
		emp.setAddress(request.getParameter("address"));
		emp.setEmail(request.getParameter("email"));
		emp.setMemo(request.getParameter("memo"));
		emp.setPhone(request.getParameter("phone"));
		
		model.create(emp);
		
		response.sendRedirect("employeeList");
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
