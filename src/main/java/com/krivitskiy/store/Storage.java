package com.krivitskiy.store;

import com.krivitskiy.models.Client;
import com.krivitskiy.models.Pet;

import java.util.Collection;
import java.util.List;

/**
 * Storage interface
 */
public interface Storage {

    /**
     * get collection of clients
     *
     * @return collection
     */
    Collection<Client> values();

    /**
     * Add client
     *
     * @param client is object that need to add in collection and db
     * @return id if added or generate exception otherwise
     */
    int addClient(final Client client);

    /**
     * Add pet
     *
     * @param pet is object that need to add in collection and db
     * @return id if added or generate exception otherwise
     */
    int addPet(final Pet pet);

    /**
     * Edit client
     *
     * @param client is object that need to edit
     */
    void editClient(final Client client);

    /**
     * Edit pet
     *
     * @param pet is object that need to edit
     */
    void editPet(final Pet pet);

    /**
     * Delete client by id
     *
     * @param clientId is id of client that need to delete
     */
    void deleteClientById(final int clientId);

    /**
     * Delete pet by id
     *
     * @param petId is id of pet that need to delete
     */
    void deletePetByPetId(final int petId);

    /**
     * get client by id
     *
     * @param clientId is id of client that need to find
     * @return found client
     */
    Client getClientById(int clientId);

    /**
     * find client with pets
     *
     * @param clientName is the name of client that need to find
     * @return found clients
     */
    List<Client> findByName(final String clientName);
}
