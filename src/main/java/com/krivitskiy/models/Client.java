package com.krivitskiy.models;

/**
 * Client class
 */
public class Client {
    /**
     * id of client
     */
    private int id;

    /**
     * name of client
     */
    private String nameOfClient;

    /**
     * phone of client
     */
    private String phoneOfClient;

    /**
     * city of client
     */
    private String cityOfClient;

    /**
     * address of client
     */
    private String addressOfClient;

    /**
     * pet of client;
     * type - class Pet
     */
    private Pet petOfClient;

    /**
     * Empty constructor
     */
    public Client() {
    }

    /**
     * Constructor with all fields of the object
     *
     * @param id              is id of client
     * @param nameOfClient    is name of client
     * @param phoneOfClient   is phone of client
     * @param cityOfClient    is city of client
     * @param addressOfClient is address of client
     * @param petOfClient     is pet of client
     */
    public Client(int id, String nameOfClient, String phoneOfClient, String cityOfClient, String addressOfClient, Pet petOfClient) {
        this.id = id;
        this.nameOfClient = nameOfClient;
        this.phoneOfClient = phoneOfClient;
        this.cityOfClient = cityOfClient;
        this.addressOfClient = addressOfClient;
        this.petOfClient = petOfClient;
    }

    /**
     * Constructor without id of client
     *
     * @param nameOfClient    is name of client
     * @param phoneOfClient   is phone of client
     * @param cityOfClient    is city of client
     * @param addressOfClient is address of client
     * @param petOfClient     is pet of client
     */
    public Client(String nameOfClient, String phoneOfClient, String cityOfClient, String addressOfClient, Pet petOfClient) {
        this.nameOfClient = nameOfClient;
        this.phoneOfClient = phoneOfClient;
        this.cityOfClient = cityOfClient;
        this.addressOfClient = addressOfClient;
        this.petOfClient = petOfClient;
    }

    /**
     * Constructor without id of client and without Pet of client
     *
     * @param nameOfClient    is name of client
     * @param phoneOfClient   is phone of client
     * @param cityOfClient    is city of client
     * @param addressOfClient is address of client
     */
    public Client(String nameOfClient, String phoneOfClient, String cityOfClient, String addressOfClient) {
        this.nameOfClient = nameOfClient;
        this.phoneOfClient = phoneOfClient;
        this.cityOfClient = cityOfClient;
        this.addressOfClient = addressOfClient;
    }

    /**
     * Constructor with id, name and pet of client
     * It's need for editing
     *
     * @param id           is id of client
     * @param nameOfClient is name of client
     * @param petOfClient  is pet of client
     */
    public Client(int id, String nameOfClient, Pet petOfClient) {
        this.id = id;
        this.nameOfClient = nameOfClient;
        this.petOfClient = petOfClient;
    }

    /**
     *
     * @param id is id of client in db
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return id of client
     */
    public int getId() {
        return this.id;
    }

    /**
     * return type - Pet
     *
     * @return pet of client
     */
    public Pet getPetOfClient() {
        return this.petOfClient;
    }


    /**
     *
     * @param nameOfClient is name of client
     */
    public void setNameOfClient(String nameOfClient) {
        this.nameOfClient = nameOfClient;
    }
    /**
     * @return name of client
     */
    public String getNameOfClient() {
        return this.nameOfClient;
    }

    /**
     * @return phone of client
     */
    public String getPhoneOfClient() {
        return phoneOfClient;
    }

    /**
     * @return city of client
     */
    public String getCityOfClient() {
        return cityOfClient;
    }

    /**
     * @return address of client
     */
    public String getAddressOfClient() {
        return addressOfClient;
    }

    /**
     * Determines whether two object references are identical
     *
     * @param otherObject is one of the object for determining
     * @return true of false
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;

        Client client = (Client) otherObject;

        return (id != client.id)
                && (nameOfClient != null ? !nameOfClient.equals(client.nameOfClient) : client.nameOfClient != null)
                && (phoneOfClient != null ? !phoneOfClient.equals(client.phoneOfClient) : client.phoneOfClient != null)
                && (cityOfClient != null ? !cityOfClient.equals(client.cityOfClient) : client.cityOfClient != null)
                && (addressOfClient != null ? !addressOfClient.equals(client.addressOfClient) : client.addressOfClient != null)
                && (petOfClient != null ? petOfClient.equals(client.petOfClient) : client.petOfClient == null);
    }

    /**
     * @return hashCode of the object
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameOfClient != null ? nameOfClient.hashCode() : 0);
        result = 31 * result + (phoneOfClient != null ? phoneOfClient.hashCode() : 0);
        result = 31 * result + (cityOfClient != null ? cityOfClient.hashCode() : 0);
        result = 31 * result + (addressOfClient != null ? addressOfClient.hashCode() : 0);
        result = 31 * result + (petOfClient != null ? petOfClient.hashCode() : 0);
        return result;
    }
}
