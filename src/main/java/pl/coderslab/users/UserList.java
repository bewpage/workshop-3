package pl.coderslab.users;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

@WebServlet(name = "UserList", value = "/user/list")
public class UserList extends HttpServlet {
  private UserDao userDao = new UserDao();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // connect to db and get all users
    User[] users = null;
    try {
      users = userDao.findAll();
      // set users as attribute
      request.setAttribute("users", users);
      System.out.println("users: " + Arrays.toString(users));
    } catch (Exception e) {
      e.printStackTrace();
    }
    // forward to list.jsp
    getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}
}
