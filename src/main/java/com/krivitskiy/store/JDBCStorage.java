package com.krivitskiy.store;

import com.krivitskiy.models.Pet;
import com.krivitskiy.models.Client;
import com.krivitskiy.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * JdbcStorage class that implements Storage interface
 * JDBC is used to connect with database
 */
public class JDBCStorage implements Storage {
    private final Connection connection;

    /**
     * SQL requests
     */
    private static final String SQL_ADD_CLIENT = "INSERT INTO client (cname, phone, city, address) VALUES (?, ?, ?, ?)";
    private static final String SQL_ADD_PET = "INSERT INTO pet (client_id, ptype, pname) VALUES (?, ?, ?)";
    private static final String SQL_GET_CLIENTS = "SELECT p.pname, p.ptype, p.client_id, c.uid, c.cname, c.phone, " +
            "c.city, c.address FROM pet as p INNER JOIN client as c ON c.uid=p.client_id";
    private static final String SQL_GET_CLIENT = "SELECT p.pname, p.ptype, p.client_id, c.uid, c.cname, c.phone," +
            " c.city, c.address FROM pet p INNER JOIN client c ON c.uid=p.client_id WHERE c.uid = ?";
    private static final String SQL_RENAME_CLIENT = "UPDATE client SET cname = ? WHERE uid = ?";
    private static final String SQL_RENAME_PET = "UPDATE pet SET pname = ? WHERE client_id = ?";
    private static final String SQL_DELETE_CLIENT = "DELETE FROM client c WHERE c.uid = ?";
    private static final String SQL_DELETE_PET = "DELETE FROM pet p WHERE p.client_id = ?";
    private static final String SQL_FIND_BY_NAME = "SELECT p.pname, p.ptype, p.client_id, c.uid, c.cname, c.phone, " +
            "c.city, c.address FROM pet as p INNER JOIN client as c ON c.uid=p.client_id WHERE c.cname = ?";

    /**
     * The constructor for configuring drivers, login, password and url for connection to the database
     */
    public JDBCStorage() {
        final Settings settings = Settings.getInstance();

        try {
            Class.forName(settings.getValue("jdbc.driver_class"));  // Не удалось настроить без этого
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(settings.getValue("jdbc.url"),
                    settings.getValue("jdbc.username"), settings.getValue("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public Collection<Client> values() {
        final List<Client> clients = new ArrayList<>();
        Pet pet;

        try (final Statement statement = this.connection.createStatement();
             final ResultSet rs = statement.executeQuery(SQL_GET_CLIENTS)) {

            while (rs.next()) {

                pet = new Pet(rs.getString("pname"),rs.getInt("uid"),
                        rs.getString("ptype"));

                clients.add(new Client(rs.getInt("uid"), rs.getString("cname"),
                        rs.getString("phone"), rs.getString("city"),
                        rs.getString("address"), pet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    @Override
    public int addClient(Client client) {
        try (final PreparedStatement preparedStatement =
                     this.connection.prepareStatement(SQL_ADD_CLIENT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, client.getNameOfClient());
            preparedStatement.setString(2, client.getPhoneOfClient());
            preparedStatement.setString(3, client.getCityOfClient());
            preparedStatement.setString(4, client.getAddressOfClient());
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new client");
    }

    @Override
    public int addPet(Pet pet) {
        try (final PreparedStatement preparedStatement =
                     this.connection.prepareStatement(SQL_ADD_PET, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, pet.getClientId());
            preparedStatement.setString(2, pet.getTypeOfPet());
            preparedStatement.setString(3, pet.getNameOfPet());
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new pet");
    }

    @Override
    public void editClient(Client client) {
        //Сначала редактируем питомца
        editPet(client.getPetOfClient());

        //Редактируем клиента
        try (final PreparedStatement preparedStatement =
                     this.connection.prepareStatement(SQL_RENAME_CLIENT)) {
            preparedStatement.setString(1, client.getNameOfClient());
            preparedStatement.setInt(2, client.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editPet(Pet pet) {
        try (final PreparedStatement preparedStatement =
                     this.connection.prepareStatement(SQL_RENAME_PET)) {
            preparedStatement.setString(1, pet.getNameOfPet());
            preparedStatement.setInt(2, pet.getClientId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClientById(int id) {
        //Сначала удаляем его питомцев
        deletePetsByClientId(id);

        //Теперь можно удалить клиента
        try(final PreparedStatement preparedStatement =
                    this.connection.prepareStatement(SQL_DELETE_CLIENT)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deletePetsByClientId(int clientId) {
        try(final PreparedStatement preparedStatement =
                    this.connection.prepareStatement(SQL_DELETE_PET)){
            preparedStatement.setInt(1, clientId);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Client getClientById(int id) {
        Pet pet;

        try (final PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_GET_CLIENT)) {
            preparedStatement.setInt(1, id);

            try (final ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    pet = new Pet(rs.getString("pname"),rs.getInt("uid"),
                            rs.getString("ptype"));

                    return new Client(rs.getInt("uid"), rs.getString("cname"),
                            rs.getString("phone"), rs.getString("city"),
                            rs.getString("address"), pet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("Client %s does not exists", id));
    }

    @Override
    public Collection<Client> findByName(String clientName, String petName) {
        final List<Client> foundClients = new ArrayList<>();
        Pet pet = null;

        try (final PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_FIND_BY_NAME);) {
            preparedStatement.setString(1, clientName);
            try (final ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    if(petName.equals(rs.getString("pname"))){
                        pet = new Pet(rs.getString("pname"),rs.getInt("uid"),
                                rs.getString("ptype"));
                    }

                    if(clientName.equals(rs.getString("cname"))){
                        foundClients.add(new Client(rs.getInt("uid"), rs.getString("cname"),
                                rs.getString("phone"), rs.getString("city"),
                                rs.getString("address"), pet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foundClients;
    }
}
