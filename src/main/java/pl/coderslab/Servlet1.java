package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// TODO: Remove this servlet after all is set up
// this is a test servlet to check if DB connection is working and if CRUD operations are working
@WebServlet(name = "Servlet1", value = "/servlet1")
public class Servlet1 extends HttpServlet {
  private UserDao userDao = new UserDao();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html; charset=utf-8");
    PrintWriter writer = response.getWriter();

    writer.append("<h1>Hello World</h1>");

    User user1 = new User("test_03@gmail.com", "username_03", "password_03");
    User test1 = null;
    try {
      User user = userDao.read(8);
      if (user != null) {
        System.out.println(user.toString());
        writer.append("<p>" + user.toString() + "</p>");
      } else {
        System.out.println("User not found");
        test1 = userDao.create(user1);
        writer.append("<p>" + test1.toString() + "</p>");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}
}
