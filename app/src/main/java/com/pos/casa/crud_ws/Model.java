package com.pos.casa.crud_ws;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Model {

    private String model;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;


    @Override
    public String toString() {
        return "Model{" +
                "model='" + model + '\'' +
                ", nome='" + firstName + '\'' +
                ", sobrenome='" + lastName + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
