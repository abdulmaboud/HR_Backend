package com.trt.HR.Model.Company;

import com.trt.HR.Model.User.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenant_id")
    private Long id;
    @Column(name = "tenant_name")

    private String name;
    @Column(name = "tenant_email")
    private String email;
    @Column(name = "tenant_domain")
    private String domain;



    // Constructors
    public Tenant() {}

    public Tenant(String name, String email, String domain) {
        this.name = name;
        this.email = email;
        this.domain = domain;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }


}