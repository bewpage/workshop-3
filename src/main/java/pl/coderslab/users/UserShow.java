package pl.coderslab.users;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserNotFoundException;
import pl.coderslab.utils.UserDao;

@WebServlet(name = "UserShow", value = "/user/show")
public class UserShow extends HttpServlet {
  private UserDao userDao;
  private User user;
  

  public void init() {
    userDao = new UserDao();
    user = new User();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userIdStr = request.getParameter("id");

    try {
      int userId = Integer.parseInt(userIdStr);
      // get user info from db
      // set user info as request attribute
      user = userDao.read(userId);
      request.setAttribute("user", user);
    } catch (UserNotFoundException | NumberFormatException e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
    // forward request to /users/show.jsp
    getServletContext().getRequestDispatcher("/users/show.jsp").forward(request, response);
  }
}
