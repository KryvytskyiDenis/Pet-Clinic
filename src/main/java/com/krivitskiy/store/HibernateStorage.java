package com.krivitskiy.store;

import com.krivitskiy.models.Client;
import com.krivitskiy.models.Pet;
import com.krivitskiy.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateStorage implements Storage {
    private final SessionFactory sessionFactory;
    /**
     * SQL requests
     */
    private static final String SQL_GET_ALL = "FROM Client";
    private static final String SQL_GET_CLIENT_BY_NAME = "FROM Client c WHERE c.nameOfClient=:nameOfClient";

    public HibernateStorage() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public interface Command<T> {
        T process(Session session);
    }

    private <T> T transaction(Command<T> command) {
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        try {
            return command.process(session);

        } finally{
            transaction.commit();
            session.close();
        }
    }

    @Override
    public List<Client> values() {

        return transaction((Session session) -> session.createQuery(SQL_GET_ALL).list());
    }

    @Override
    public int addClient(Client client) {
        return transaction((Session session) -> {
            session.save(client);
            return client.getId();
        });
    }

    @Override
    public int addPet(Pet pet) {
        return transaction((Session session) -> {
            session.save(pet);
            return pet.getId();
        });
    }

    @Override
    public void editClient(Client client) {
        transaction((Session session) -> {
            session.update(client);
            return null;
        });
    }

    @Override
    public void editPet(Pet pet) {
        transaction((Session session) -> {
            session.update(pet);
            return null;
        });
    }

    @Override
    public void deleteClientById(int clientId) {
        transaction((Session session) -> {
            session.delete(session.get(Client.class, clientId));
            return null;
        });
    }

    @Override
    public void deletePetByPetId(int petId) {
        transaction((Session session) -> {
            session.delete(petId);
            return null;
        });
    }

    @Override
    public Client getClientById(int clientId) {
        return transaction((Session session) -> (Client) session.get(Client.class, clientId));
    }

    @Override
    public List<Client> findByName(String nameOfClient) {
        return transaction((Session session)->{
            final Query query = session.createQuery(SQL_GET_CLIENT_BY_NAME);
            query.setString("nameOfClient", nameOfClient);
            return (List<Client>)query.list();
        });
    }
}
