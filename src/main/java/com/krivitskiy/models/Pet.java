package com.krivitskiy.models;

import javax.persistence.*;

/**
 * Pet class
 */
@Entity
@Table(name = "pet")
public class Pet {
    /**
     * id of pet
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private int id;

    /**
     * Name of pet
     */
    @Column(name = "pname")
    private String nameOfPet;

    /**
     * Master of pet
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    private Client masterOfPet;

    /**
     * Type of pet
     */
    @Column(name = "ptype")
    private String typeOfPet;

    /**
     * Empty constructor
     */
    public Pet() {
    }

    /**
     * Constructor of class with two params
     *
     * @param nameOfPet is a name of the pet
     */
    public Pet(String nameOfPet, String typeOfPet) {
        this.nameOfPet = nameOfPet;
        this.typeOfPet = typeOfPet;
    }

    /**
     * Constructor with all params
     * @param nameOfPet is a name of the pet
     * @param masterOfPet is a master of the pet
     * @param typeOfPet is a type of the pet
     */
    public Pet(String nameOfPet, Client masterOfPet, String typeOfPet) {
        this.nameOfPet = nameOfPet;
        this.masterOfPet = masterOfPet;
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
     * @param typeOfPet is type of pet
     */
    public void setTypeOfPet(String typeOfPet) {
        this.typeOfPet = typeOfPet;
    }

    /**
     *
     * @return Client object
     */
    public Client getMasterOfPet() {
        return masterOfPet;
    }

    /**
     *
     * @param masterOfPet is Client object
     */
    public void setMasterOfPet(Client masterOfPet) {
        this.masterOfPet = masterOfPet;
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

        Pet pet = (Pet) otherObject;

        if (id != pet.id) return false;
        if (nameOfPet != null ? !nameOfPet.equals(pet.nameOfPet) : pet.nameOfPet != null) return false;
        return typeOfPet != null ? typeOfPet.equals(pet.typeOfPet) : pet.typeOfPet == null;
    }

    /**
     *
     * @return hashCode of the object
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameOfPet != null ? nameOfPet.hashCode() : 0);
        result = 31 * result + (masterOfPet != null ? masterOfPet.hashCode() : 0);
        result = 31 * result + (typeOfPet != null ? typeOfPet.hashCode() : 0);
        return result;
    }
}
