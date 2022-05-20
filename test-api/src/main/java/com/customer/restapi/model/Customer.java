package com.customer.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Customer {

    private int id;
    @NotBlank(message = "A name must be provided")
    @NotNull(message = "A name must be provided")
    private String name;
    @NotBlank(message = "A surname must be provided")
    @NotNull(message = "A surname must be provided")
    private String surname;
    @NotBlank
    @NotNull
    @Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$", message = "Birthdate must entered in format 'YYYY-MM-DD'")
    private String birthdate;
    @NotBlank
    @NotNull
    private String phoneNumber;
    @NotBlank(message = "An email address must be provided")
    @NotNull(message = "An email address must be provided")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email must be entered in correct format")
    private String email;

    public Customer(
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("birthdate") String birthdate,
            @JsonProperty("phoneNumber") String phoneNumber,
            @JsonProperty("email") String email) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}