package com.ab.model.user;

import com.ab.model.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity(name = "user_details")
@NamedQueries({
    @NamedQuery(name = "user.auth",
        query = "SELECT u.email FROM com.ab.model.user.User u " +
                "WHERE u.email = :email " +
                "AND u.password = :password ")
})
public class User extends BaseEntity {

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_role")
    private String role;

    @Column(name = "contact_first_name")
    private String firstName;

    @Column(name = "contact_last_name")
    private String lastName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "contact_phone")
    private long phone;

    public User() {
    }

    public User(String email, String password, String role, String firstName,
                String lastName, Address address, long phone, String mobile) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.role = role;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
