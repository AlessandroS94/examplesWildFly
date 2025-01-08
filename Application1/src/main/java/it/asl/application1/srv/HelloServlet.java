package it.asl.application1.srv;

import it.asl.application1.dao.ArticoloDao;
import it.asl.application1.model.Articolo;
import lombok.SneakyThrows;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void init() {

    }

    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArticoloDao articoloDao = new ArticoloDao();
        List<Articolo> articoli;
        try {
            articoli = articoloDao.showAllArticoli();
        } catch (SQLException e) {
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
            return;
        }
        request.setAttribute("articoli", articoli); // Attach object as an attribute
        RequestDispatcher dispatcher = request.getRequestDispatcher("articoli.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
            throw new IOException("Forwarding to articoli.jsp failed", e);
        }
    }

    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Articolo articolo = new Articolo(request.getParameter("nome"),request.getParameter("descrizione"), Integer.parseInt(request.getParameter("quantita")));
        ArticoloDao articoloDao = new ArticoloDao();
        articoloDao.insertArticoli(articolo);
        response.sendRedirect(request.getContextPath() + "/hello-servlet");
    }

    @SneakyThrows
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Articolo articolo = new Articolo(request.getParameter("nome"),request.getParameter("descrizione"), Integer.parseInt(request.getParameter("quantita")));
        ArticoloDao articoloDao = new ArticoloDao();
        articoloDao.insertArticoli(articolo);
        response.sendRedirect(request.getContextPath() + "/hello-servlet");
    }

    public void destroy() {
        System.out.println("destroying servlet");
    }
}