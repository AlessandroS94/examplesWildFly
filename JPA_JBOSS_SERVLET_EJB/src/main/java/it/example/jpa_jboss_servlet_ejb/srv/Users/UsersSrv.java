package it.example.jpa_jboss_servlet_ejb.srv.Users;

import it.example.jpa_jboss_servlet_ejb.model.User;
import it.example.jpa_jboss_servlet_ejb.service.interfaces.UserServiceLocal;


import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "index", value = "")
public class UsersSrv extends HttpServlet {
    @EJB
    private UserServiceLocal userService;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<User> users = userService.findAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    public void destroy() {
    }
}