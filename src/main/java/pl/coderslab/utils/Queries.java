package pl.coderslab.utils;

public class Queries {
  protected static final String CREATE_USER_QUERY =
      "INSERT INTO users(email, username, password) VALUES(?, ?, ?)";
  protected static final String FIND_USER_QUERY = "SELECT * FROM users WHERE id = ?";
  protected static final String UPDATE_USER_QUERY =
      "UPDATE users SET email = ?, username = ?, password = ? WHERE id = ?";
  protected static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";
  protected static final String FIND_ALL_QUERY = "SELECT * FROM users";
}
