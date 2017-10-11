package com.krivitskiy.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Client class
 */

@Entity
@Table(name = "client")
public class Client {
    /**
     * id of client
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private int id;

    /**
     * name of client
     */
    @Column(name = "cname")
    private String nameOfClient;

    /**
     * phone of client
     */
    @Column(name = "phone")
    private String phoneOfClient;

    /**
     * city of client
     */
    @Column(name = "city")
    private String cityOfClient;

    /**
     * address of client
     */
    @Column(name = "address")
    private String addressOfClient;

    /**
     * pet of client;
     * type - class Pet
     */
    @OneToMany(mappedBy = "masterOfPet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Pet> petsOfClient;

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
     * @param petsOfClient    is pet of client
     */
    public Client(int id, String nameOfClient, String phoneOfClient, String cityOfClient, String addressOfClient, Set<Pet> petsOfClient) {
        this.id = id;
        this.nameOfClient = nameOfClient;
        this.phoneOfClient = phoneOfClient;
        this.cityOfClient = cityOfClient;
        this.addressOfClient = addressOfClient;
        this.petsOfClient = petsOfClient;
    }

    /**
     * Constructor without id of client
     *
     * @param nameOfClient    is name of client
     * @param phoneOfClient   is phone of client
     * @param cityOfClient    is city of client
     * @param addressOfClient is address of client
     * @param petsOfClient    is pet of client
     */
    public Client(String nameOfClient, String phoneOfClient, String cityOfClient, String addressOfClient, Set<Pet> petsOfClient) {
        this.nameOfClient = nameOfClient;
        this.phoneOfClient = phoneOfClient;
        this.cityOfClient = cityOfClient;
        this.addressOfClient = addressOfClient;
        this.petsOfClient = petsOfClient;
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
     * @param petsOfClient is pet of client
     */
    public Client(int id, String nameOfClient, Set<Pet> petsOfClient) {
        this.id = id;
        this.nameOfClient = nameOfClient;
        this.petsOfClient = petsOfClient;
    }

    /**
     * Constructor without id of client and without Pet of client
     *
     * @param id              is id of client
     * @param nameOfClient    is name of client
     * @param phoneOfClient   is phone of client
     * @param cityOfClient    is city of client
     * @param addressOfClient is address of client
     */
    public Client(int id, String nameOfClient, String phoneOfClient, String cityOfClient, String addressOfClient) {
        this.id = id;
        this.nameOfClient = nameOfClient;
        this.phoneOfClient = phoneOfClient;
        this.cityOfClient = cityOfClient;
        this.addressOfClient = addressOfClient;
    }

    /**
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
    public Set<Pet> getPetsOfClient() {
        return this.petsOfClient;
    }


    /**
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
     * @param phoneOfClient is phone of client
     */
    public void setPhoneOfClient(String phoneOfClient) {
        this.phoneOfClient = phoneOfClient;
    }

    /**
     * @param cityOfClient is city of client
     */
    public void setCityOfClient(String cityOfClient) {
        this.cityOfClient = cityOfClient;
    }

    /**
     * @param addressOfClient is address of client
     */
    public void setAddressOfClient(String addressOfClient) {
        this.addressOfClient = addressOfClient;
    }

    /**
     * @param petsOfClient is pet of client
     */
    public void setPetsOfClient(Set<Pet> petsOfClient) {
        this.petsOfClient = petsOfClient;
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
                && (addressOfClient != null ? !addressOfClient.equals(client.addressOfClient) : client.addressOfClient != null);
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
        return result;
    }
}
