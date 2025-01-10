package it.example.servlet_jpa.srv.Users;

import it.example.servlet_jpa.DAO.UsersDAO;
import it.example.servlet_jpa.model.User;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "index", value = "")
public class UsersSrv extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UsersDAO dao = new UsersDAO();
        List<User> users = dao.getAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    public void destroy() {
    }
}