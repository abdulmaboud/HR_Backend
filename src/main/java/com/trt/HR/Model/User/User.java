package com.trt.HR.Model.User;

import com.trt.HR.Model.Company.Tenant;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tenant_id")  // Foreign key column in the User table
    private Tenant tenant;

    private String username;
    private String password;
    private String email;
    private String company;

    // Constructors
    public User() {}

    public User(Long id, Tenant tenant, String username, String password, String email, String company) {
        this.id = id;
        this.tenant = tenant;
        this.username = username;
        this.password = password;
        this.email = email;
        this.company = company;
    }

    public User(Tenant tenant, String username, String password) {
        this.tenant = tenant;
        this.username = username;
        this.password = password;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}