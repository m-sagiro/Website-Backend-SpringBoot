package com.msagiroglu.backendspringboot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CustomUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Date dateOfBirth;

    public CustomUser() {

    }

    public CustomUser(Long id, String username, String firstName, String lastName, int age, String email, Date dateOfBirth) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String toString(){
        return "User {" +
                " Id = " + id + "," +
                " Username = " + username + "," +
                " First name = " + firstName + "," +
                " Last name = " + lastName + "," +
                " Age = " + age + "," +
                " email = " + email + "," +
                " Date of birth = " + dateOfBirth +
                " }";
    }


}
