package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trng.EmployeeJDBCLibrary.Employee;
import trng.EmployeeJDBCLibrary.EmployeeDBOperations;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("pages/search.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String test = request.getParameter("employeeId");
		int empId = Integer.parseInt(request.getParameter("employeeId"));
		EmployeeDBOperations empObj;
		try {
			empObj = new EmployeeDBOperations();
			Employee obj;
			try {

				obj = empObj.findEmployee(empId);
				// System.out.println(obj.toString());

				if (obj.getEmployeeNo() == 0) {
					request.setAttribute("message", "This is invalid employee ID, Please try again");

				} else {
					int id = obj.getEmployeeNo();
					String name = obj.getEmployeeName();
					float salary = obj.getSalary();
					int year = obj.getYearOfJoin();
					int age = obj.getAge();

					request.setAttribute("id", id);
					request.setAttribute("name", name);
					request.setAttribute("salary", salary);
					request.setAttribute("year", year);
					request.setAttribute("age", age);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		doGet(request, response);

	}

}
