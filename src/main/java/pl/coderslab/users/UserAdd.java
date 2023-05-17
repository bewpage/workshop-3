package pl.coderslab.users;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import pl.coderslab.entity.User;
import pl.coderslab.utils.UserDao;

@WebServlet(name = "UserAdd", value = "/user/add")
public class UserAdd extends HttpServlet {
  private UserDao userDao = new UserDao();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    getServletContext().getRequestDispatcher("/users/add.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    try {
      User newUser = new User(email, username, password);
      User test = userDao.create(newUser);
    } catch (Exception e) {
      e.printStackTrace();
    }
    response.sendRedirect(request.getContextPath() + "/user/list");
  }
}
