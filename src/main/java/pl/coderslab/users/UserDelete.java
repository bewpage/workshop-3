package pl.coderslab.users;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import pl.coderslab.utils.UserDao;

@WebServlet(name = "UserDelete", value = "/user/delete")
public class UserDelete extends HttpServlet {

  private UserDao userDao;

  public void init() {
    userDao = new UserDao();
  }

  /**
   * Reads the stream into a string
   *
   * @param iStream the input stream
   * @return the string read from the stream
   * @throws IOException when an IO error occurs
   */
  private String readStream(InputStream iStream) throws IOException {

    // Buffered reader allows us to read line by line
    try (BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream))) {
      StringBuilder builder = new StringBuilder();
      String line;
      while ((line = bReader.readLine()) != null) { // Read till end
        builder.append(line);
        builder.append("\n"); // append new line to preserve lines
      }
      return builder.toString();
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      ObjectMapper mapper = new ObjectMapper();
      ServletInputStream stream = request.getInputStream();
      String json = readStream(stream);

      JsonNode nameNode = mapper.readTree(json);
      System.out.println(nameNode.get("id").asText());
      int id = Integer.parseInt(nameNode.get("id").asText());
      userDao.delete(id);

    } catch (IOException | RuntimeException e) {
      // response server error
      response.setStatus(400);
      e.printStackTrace();
    }

    getServletContext().getRequestDispatcher("/users/list.jsp").forward(request, response);
  }
}
