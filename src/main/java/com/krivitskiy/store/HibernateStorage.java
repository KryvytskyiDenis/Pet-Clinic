package com.krivitskiy.store;

import com.krivitskiy.models.Client;
import com.krivitskiy.models.Pet;
import com.krivitskiy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;

public class HibernateStorage implements Storage {

    /**
     * SQL requests
     */
    private static final String SQL_GET_CLIENTS = "from Client";

    @Override
    public Collection<Client> values() {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            return session.createQuery(SQL_GET_CLIENTS).list();
        } finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public int addClient(Client client) {
        return 0;
    }

    @Override
    public int addPet(Pet pet) {
        return 0;
    }

    @Override
    public void editClient(Client client) {

    }

    @Override
    public void editPet(Pet pet) {

    }

    @Override
    public void deleteClientById(int clientId) {

    }

    @Override
    public void deletePetsByClientId(int clientId) {

    }

    @Override
    public Client getClientById(int clientId) {
        return null;
    }

    @Override
    public Collection<Client> findByName(String clientName, String petName) {
        return null;
    }
}
