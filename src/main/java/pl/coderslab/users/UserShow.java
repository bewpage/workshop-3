package pl.coderslab.users;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import pl.coderslab.utils.UserDao;

@WebServlet(name = "UserShow", value = "/user/show")
public class UserShow extends HttpServlet {
  UserDao userDao = new UserDao();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userIdStr = request.getParameter("id");

    try {
      int userId = Integer.parseInt(userIdStr);
      // get user info from db
      // set user info as request attribute
      request.setAttribute("user", userDao.read(userId));
    } catch (NumberFormatException e) {
      e.printStackTrace();
    }
    // forward request to /users/show.jsp
    getServletContext().getRequestDispatcher("/users/show.jsp").forward(request, response);
  }
}
