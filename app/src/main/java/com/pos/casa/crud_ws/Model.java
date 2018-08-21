package com.pos.casa.crud_ws;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Model {


    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;


    @Override
    public String toString() {
        return "Pessoa{" +
                ", nome='" + firstName + '\'' +
                ", sobrenome='" + lastName + '\'' +
                '}';
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
