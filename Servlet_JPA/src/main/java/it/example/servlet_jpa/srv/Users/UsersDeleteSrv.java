package it.example.servlet_jpa.srv.Users;

import it.example.servlet_jpa.DAO.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteUser", value = "/delete-user")
public class UsersDeleteSrv extends HttpServlet {

    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDAO usersDAO = new UsersDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        usersDAO.deleteUser(id);
        response.sendRedirect("");
    }
}
