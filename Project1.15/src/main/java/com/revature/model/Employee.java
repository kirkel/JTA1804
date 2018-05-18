package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {

    private static final long serialVersionUID = -678047195085608127L;
    private int eId;
    private String username;
    private String userpass;
    private String firstName;
    private String lastName;
    private String role;

    public Employee() {
    }

    public Employee(int eId, String username, String userpass, String firstName, String lastName, String role) {
        this.eId = eId;
        this.username = username;
        this.userpass = userpass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return eId == employee.eId &&
                Objects.equals(username, employee.username) &&
                Objects.equals(userpass, employee.userpass) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(eId, username, userpass, firstName, lastName, role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
