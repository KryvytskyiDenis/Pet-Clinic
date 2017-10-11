package com.krivitskiy.servlets;

import com.krivitskiy.models.*;
import com.krivitskiy.store.HibernateStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientCreateServlet extends HttpServlet {
    private final HibernateStorage storage = new HibernateStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
        Client client;

        String nameOfClient = req.getParameter("nameOfClient");
        String phone = req.getParameter("phoneOfClient");
        String city = req.getParameter("cityOfClient");
        String address = req.getParameter("addressOfClient");
        String petType = req.getParameter("ClassOfPet");
        String nameOfPet = req.getParameter("nameOfPet");

        client = new Client(nameOfClient, phone, city, address);

        storage.addPet(new Pet(nameOfPet, client, petType));

        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
