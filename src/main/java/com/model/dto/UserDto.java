package com.model.dto;

public class UserDto {
    private Long idpengguna;
    private String emailpengguna;
    private String password;
    private String firstName;
    private String lastName;
    private String peranAs;


    public Long getIdpengguna() {
        return idpengguna;
    }

    public void setIdpengguna(Long idpengguna) {
        this.idpengguna = idpengguna;
    }

    public String getEmailpengguna() {
        return emailpengguna;
    }

    public void setEmailpengguna(String emailpengguna) {
        this.emailpengguna = emailpengguna;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPeranAs() {
        return peranAs;
    }

    public void setPeranAs(String peranAs) {
        this.peranAs = peranAs;
    }
}
