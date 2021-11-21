package usermanagement.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.result.DeleteResult;

import usermanagement.dao.UserDao;
import usermanagement.model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	public UserServlet() {

		this.userDao = new UserDao();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String action = request.getServletPath();

			switch (action) {
			case "/new":
				showFormUser(request, response);
				break;

			case "/store":
				storeUser(request, response);
				break;

			case "/update":
				showUserToUpdate(request, response);
				break;

			case "/store-update":
				updateUser(request, response);
				break;

			case "/delete":
				deleteUser(request, response);
				break;

			case "/list":
				allUser(request, response);
				break;

			default:
				allUser(request, response);
				break;
			}

		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	protected void allUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<User> users = userDao.getAll();

			request.setAttribute("users", users);

			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");

			dispatcher.forward(request, response);

		} catch (ServletException ex) {
			System.err.println(ex.getMessage());
		}
	}

	protected void showFormUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");

		dispatcher.forward(request, response);

	}

	protected void showUserToUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = userDao.getItem(request.getParameter("_id"));

		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");

		dispatcher.forward(request, response);

	}

	protected void storeUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setCountry(request.getParameter("country"));

		userDao.create(user);
		response.sendRedirect("list");

	}

	protected void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DeleteResult vr = userDao.delete(request.getParameter("_id"));

		response.sendRedirect("list");

	}

	protected void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("_id");

		User user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setCountry(request.getParameter("country"));

		userDao.update(id, user);
		response.sendRedirect("list");

	}

}
