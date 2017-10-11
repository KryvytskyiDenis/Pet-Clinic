package com.krivitskiy.servlets;

import com.krivitskiy.models.Client;
import com.krivitskiy.store.HibernateStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientEditServlet extends HttpServlet {

    private final HibernateStorage storage = new HibernateStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("client", this.storage.getClientById(Integer.valueOf(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/EditClient.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int client_id = Integer.valueOf(req.getParameter("id"));
        this.storage.editClient(new Client(client_id, req.getParameter("nameOfClient"),
                req.getParameter("phoneOfClient"),req.getParameter("cityOfClient"),
                req.getParameter("addressOfClient")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
