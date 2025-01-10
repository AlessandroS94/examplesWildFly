package it.example.servlet_jdbc.Users;



import it.example.servlet_jdbc.DAO.UsersDAO.UsersDAO;
import it.example.servlet_jdbc.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="update-user", value = "/update-user")
public class UsersUpdateSrv extends HttpServlet  {

    public void doGet(HttpServletRequest request, HttpServletResponse response){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("id") == null && request.getParameter("name") == null && request.getParameter("email") == null && request.getParameter("country") == null) {
            response.sendRedirect("");
            return;
        }
        User user = new User(Integer.parseInt(request.getParameter("id")),request.getParameter("name").toString(), request.getParameter("email").toString(), request.getParameter("country").toString());
        try{
            UsersDAO usersDao = new UsersDAO();
            usersDao.updateUser(user);
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        response.sendRedirect("");
    }
}
