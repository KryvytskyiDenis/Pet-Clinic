package com.krivitskiy.models;

/**
 * Pet class
 */
public class Pet {
    /**
     * id of pet
     */
    private int id;

    /**
     * Name of pet
     */
    private String nameOfPet;
    /**
     * Pet owner's id
     */
    private int clientId;
    /**
     * Type of pet
     */
    private String typeOfPet;

    /**
     * Constructor of class with two params
     *
     * @param nameOfPet is a name of the pet
     */
    public Pet(String nameOfPet, int clientId, String typeOfPet) {
        this.nameOfPet = nameOfPet;
        this.clientId = clientId;
        this.typeOfPet = typeOfPet;
    }

    /**
     * Get name of the pet
     * @return name of the pet
     */
    public String getNameOfPet() {
        return nameOfPet;
    }

    /**
     * Get pet owner's id
     * @return clientId
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Get type of pet
     * @return typeOfPet
     */
    public String getTypeOfPet() {
        return typeOfPet;
    }

    /**
     *
     * @return id of pet
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id of pet
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param nameOfPet for pet
     */
    public void setNameOfPet(String nameOfPet) {
        this.nameOfPet = nameOfPet;
    }

    /**
     *
     * @param clientId is an id of client
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     *
     * @param typeOfPet is type of pet
     */
    public void setTypeOfPet(String typeOfPet) {
        this.typeOfPet = typeOfPet;
    }

    /**
     * Determines whether two object references are identical
     * @param otherObject is one of the object for determining
     * @return true of false
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;

        Pet that = (Pet) otherObject;
        
        return (clientId != that.clientId)
                && (nameOfPet != null ? !nameOfPet.equals(that.nameOfPet) : that.nameOfPet != null)
                && typeOfPet != null ? typeOfPet.equals(that.typeOfPet) : that.typeOfPet == null;
    }

    /**
     *
     * @return hashCode of the object
     */
    @Override
    public int hashCode() {
        int result = nameOfPet != null ? nameOfPet.hashCode() : 0;
        result = 31 * result + clientId;
        result = 31 * result + (typeOfPet != null ? typeOfPet.hashCode() : 0);
        return result;
    }
}
