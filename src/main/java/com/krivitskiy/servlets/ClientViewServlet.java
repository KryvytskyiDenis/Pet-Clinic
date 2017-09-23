package com.krivitskiy.servlets;

import com.krivitskiy.store.JDBCStorage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientViewServlet extends HttpServlet {

    private final JDBCStorage storage = new JDBCStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clients", this.storage.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/ClientView.jsp");
        dispatcher.forward(req, resp);
    }
}
