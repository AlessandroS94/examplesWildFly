package it.example.servlet_jdbc.DAO.UsersDAO;

import it.example.servlet_jdbc.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    private Connection conn = null;
    private java.sql.ResultSet rs = null;

    public UsersDAO() throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        Class.forName(driver);
        this.conn = java.sql.DriverManager.getConnection(url, user, null);
    }

    public void destroy() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public void insertUser(User user) {
        String prepereStatementInsertUser = "INSERT INTO demo.users (name, email, country) VALUES (?,?,?)";
        try (java.sql.PreparedStatement pstmt = conn.prepareStatement(prepereStatementInsertUser)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());
            pstmt.executeUpdate();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
        }
    }

    public void updateUser(User user) {
        String prepereStatementUpdateUser = "UPDATE demo.users u SET u.name=?, u.email=?, u.country=? WHERE u.id = ?";
        try (java.sql.PreparedStatement pstmt = conn.prepareStatement(prepereStatementUpdateUser)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());
            pstmt.setInt(4, user.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
        }
    }

    public User getUser(int id) {
        User user = null;
        String prepereStatementGetUser = "SELECT * FROM demo.users WHERE id = ?";
        try(java.sql.PreparedStatement pstmt = conn.prepareStatement(prepereStatementGetUser)){
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public void deleteUser(int id) {
        String prepereStatementDeleteUser = "DELETE FROM demo.users WHERE id = ?";
        try(java.sql.PreparedStatement preparedStatement = conn.prepareStatement(prepereStatementDeleteUser)){
            preparedStatement.setInt(1, id);
            //Execute Query se c'è un preparestatement da aggiornare
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String prepereStatementGetAllUsers = "SELECT * FROM demo.users";
        try(java.sql.PreparedStatement pstmt = conn.prepareStatement(prepereStatementGetAllUsers)) {
            //Execute Query se non c'è un preparestatement da aggiornare
            rs = pstmt.executeQuery();
            while(rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                users.add(user);
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}
