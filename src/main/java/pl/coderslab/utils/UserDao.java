package pl.coderslab.utils;

import java.sql.*;
import java.util.Arrays;
import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.entity.User;
import pl.coderslab.entity.UserNotFoundException;

public class UserDao extends Queries {
  enum Column {
    ID,
    USERNAME,
    EMAIL,
    PASSWORD
  }

  public String hashPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }

  // ---- CREATE ----
  public User create(User user) {
    try (Connection conn = DbUtil.getConnection();
        PreparedStatement statement =
            conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS); ) {
      statement.setString(1, user.getEmail());
      statement.setString(2, user.getUsername());
      statement.setString(3, hashPassword(user.getPassword()));
      statement.executeUpdate();

      try (ResultSet resultSet = statement.getGeneratedKeys()) {
        if (resultSet.next()) {
          long generatedId = resultSet.getLong(1);
          return new User(generatedId, user.getEmail(), user.getUsername(), user.getPassword());
        } else {
          throw new RuntimeException("Failed to create user");
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // ---- READ ----
  public User read(long userId) {
    try (Connection conn = DbUtil.getConnection();
        PreparedStatement statement = conn.prepareStatement(FIND_USER_QUERY)) {
      statement.setLong(1, userId);
      try (ResultSet resultSet = statement.executeQuery()) {
        if (resultSet.next()) {
          return createUser(resultSet);
        } else {
          throw new UserNotFoundException(userId);
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private static User createUser(ResultSet resultSet) throws SQLException {
    long userId = resultSet.getLong(Column.ID.name());
    String username = resultSet.getString(Column.USERNAME.name());
    String email = resultSet.getString(Column.EMAIL.name());
    String password = resultSet.getString(Column.PASSWORD.name());
    return new User(userId, email, username, password);
  }

  // ---- UPDATE ----
  public void update(User user) {
    try (Connection conn = DbUtil.getConnection();
        PreparedStatement statement = conn.prepareStatement(UPDATE_USER_QUERY)) {
      statement.setString(1, user.getEmail());
      statement.setString(2, user.getUsername());
      statement.setString(3, hashPassword(user.getPassword()));
      statement.setLong(4, user.getId());
      statement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // ---- DELETE ----
  public void delete(long userId) {
    try (Connection conn = DbUtil.getConnection();
        PreparedStatement statement = conn.prepareStatement(DELETE_USER_QUERY)) {
      statement.setLong(1, userId);
      statement.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  // ---- FIND ALL USERS ----
  public User[] findAll() {
    User[] users = {};
    try (Connection conn = DbUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(FIND_ALL_QUERY)) {
      while (resultSet.next()) {
        User newUser = createUser(resultSet);
        users = addToArray(newUser, users);
      }
      return users;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  private User[] addToArray(User u, User[] users) {
    User[] tmpUsers =
        Arrays.copyOf(users, users.length + 1); // Tworzymy kopię tablicy powiększoną o 1.
    tmpUsers[users.length] = u; // Dodajemy obiekt na ostatniej pozycji.
    return tmpUsers; // Zwracamy nową tablicę.
  }
}
