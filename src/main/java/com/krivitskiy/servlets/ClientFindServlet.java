package com.krivitskiy.servlets;

import com.krivitskiy.store.JDBCStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientFindServlet extends HttpServlet {

    private final JDBCStorage storage = new JDBCStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("nameOfClient") != null || req.getParameter("nameOfPet") != null){
            req.setAttribute("found", this.storage.findByName(req.getParameter("nameOfClient"),req.getParameter("nameOfPet")));
        }

        req.getRequestDispatcher("/views/client/FindClient.jsp").forward(req, resp);
    }
}
