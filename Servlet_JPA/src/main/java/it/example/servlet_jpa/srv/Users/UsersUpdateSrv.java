package it.example.servlet_jpa.srv.Users;

import it.example.servlet_jpa.DAO.UsersDAO;
import it.example.servlet_jpa.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="update-user", value = "/update-user")
public class UsersUpdateSrv extends HttpServlet  {

    public void doGet(HttpServletRequest request, HttpServletResponse response){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("id") == null && request.getParameter("name") == null && request.getParameter("email") == null && request.getParameter("country") == null) {
            response.sendRedirect("");
            return;
        }
        User user = new User(Integer.parseInt(request.getParameter("id")),request.getParameter("name").toString(), request.getParameter("email").toString(), request.getParameter("country").toString());
        UsersDAO usersDao = new UsersDAO();
        usersDao.updateUser(user);
        response.sendRedirect("");
    }
}
