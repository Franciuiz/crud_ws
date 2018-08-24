package com.pos.casa.crud_ws;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Persons {


    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    private Date createdAt;

    private Date updatedAt;


    @Override
    public String toString() {
        return "Pessoa {" + '\n' +
                "       Id: " + id + '\n' +
                "       Nome: " + firstName + '\n' +
                "       Sobrenome: " + lastName + '\n' +
                "       Criado em: " + createdAt + '\n' +
                "       Alterado em: " + updatedAt + '\n' +
                '}';

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
