package pl.coderslab.users;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import pl.coderslab.utils.UserDao;

@WebServlet(name = "UserList", value = "/user/list")
public class UserList extends HttpServlet {
  private UserDao userDao = new UserDao();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // connect to db and get all users
    try {
      // set users as attribute
      request.setAttribute("users", userDao.findAll());
    } catch (Exception e) {
      e.printStackTrace();
    }
    // forward to list.jsp
    getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);
  }
}
