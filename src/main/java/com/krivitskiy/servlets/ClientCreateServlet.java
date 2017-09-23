package com.krivitskiy.servlets;

import com.krivitskiy.models.*;
import com.krivitskiy.store.JDBCStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientCreateServlet extends HttpServlet {
    private final JDBCStorage storage = new JDBCStorage();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NullPointerException {
        Pet pet = null;

        String name = req.getParameter("nameOfClient");
        String phone = req.getParameter("phoneOfClient");
        String city = req.getParameter("cityOfClient");
        String address = req.getParameter("addressOfClient");
        String petType = req.getParameter("ClassOfPet");

        try {
            pet = new Pet(req.getParameter("nameOfPet"),
                    storage.addClient(new Client(name, phone, city, address)), petType);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        storage.addPet(pet);

        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/client/view"));
    }
}
