package pl.coderslab.users;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import pl.coderslab.entity.User;
import pl.coderslab.utils.UserDao;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
  private UserDao userDao;
  private User user;

  public void init() {
    userDao = new UserDao();
    user = new User();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // get id from list button
    String userId = request.getParameter("id");
    System.out.println("userId: " + userId);
    // get user from db
    try {
      // set user as attribute
      user = userDao.read(Integer.parseInt(userId));
      request.setAttribute("user", user);
    } catch (Exception e) {
      e.printStackTrace();
    }
    // forward to edit.jsp
    getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // get id from edit.jsp
    String userId = request.getParameter("id");
    // submit changes to db
    try {
      // get user from db
      user.setUsername(request.getParameter("username"));
      user.setEmail(request.getParameter("email"));
      user.setPassword(request.getParameter("password"));
      // update user in db
      userDao.update(user);
    } catch (Exception e) {
      e.printStackTrace();
    }
    // redirect to list
    response.sendRedirect(request.getContextPath() + "/user/list");
  }
}
