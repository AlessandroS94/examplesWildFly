package it.example.servlet_jdbc.Users;

import it.example.servlet_jdbc.DAO.UsersDAO.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "deleteUser", value = "/delete-user")
public class UsersDeleteSrv extends HttpServlet {

    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            UsersDAO usersDAO = new UsersDAO();
            usersDAO.deleteUser(id);
        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("");
    }
}
