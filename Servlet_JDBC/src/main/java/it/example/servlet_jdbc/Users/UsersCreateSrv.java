package it.example.servlet_jdbc.Users;

import it.example.servlet_jdbc.DAO.UsersDAO.UsersDAO;
import it.example.servlet_jdbc.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "create-user", value = "/create-user")
public class UsersCreateSrv extends HttpServlet {

    public void init(){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setCountry(request.getParameter("country"));
        try {
            UsersDAO dao = new UsersDAO();
            dao.insertUser(user);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("");
    }
}
