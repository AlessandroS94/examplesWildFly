package it.example.jpa_jboss_servlet_ejb.srv.Users;

import it.example.jpa_jboss_servlet_ejb.model.User;
import it.example.jpa_jboss_servlet_ejb.service.interfaces.UserServiceLocal;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "create-user", value = "/create-user")
public class UsersCreateSrv extends HttpServlet {

    @EJB
    private UserServiceLocal userService;

    public void init(){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setCountry(request.getParameter("country"));
        this.userService.createUser(user);
        response.sendRedirect("");
    }
}
