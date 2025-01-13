package it.example.jpa_jboss_servlet_ejb.srv.Users;

import it.example.jpa_jboss_servlet_ejb.model.User;
import it.example.jpa_jboss_servlet_ejb.service.interfaces.UserServiceLocal;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="update-user", value = "/update-user")
public class UsersUpdateSrv extends HttpServlet  {
    @EJB
    private UserServiceLocal userService;

    public void doGet(HttpServletRequest request, HttpServletResponse response){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("id") == null && request.getParameter("name") == null && request.getParameter("email") == null && request.getParameter("country") == null) {
            response.sendRedirect("");
            return;
        }
        User user = new User(Integer.parseInt(request.getParameter("id")),request.getParameter("name").toString(), request.getParameter("email").toString(), request.getParameter("country").toString());
        this.userService.updateUser(user);
        response.sendRedirect("");
    }
}
