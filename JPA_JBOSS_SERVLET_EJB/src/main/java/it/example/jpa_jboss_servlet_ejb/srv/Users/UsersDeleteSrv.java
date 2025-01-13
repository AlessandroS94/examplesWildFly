package it.example.jpa_jboss_servlet_ejb.srv.Users;


import it.example.jpa_jboss_servlet_ejb.service.interfaces.UserServiceLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteUser", value = "/delete-user")
public class UsersDeleteSrv extends HttpServlet {
    @EJB
    private UserServiceLocal userService;

    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.userService.deleteUser(id);
        response.sendRedirect("");
    }
}
