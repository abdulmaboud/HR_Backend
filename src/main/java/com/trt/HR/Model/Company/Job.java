package com.trt.HR.Model.Company;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long id;

    private String major;
    private String role;



    // Constructors, getters, and setters
    public Job() {
    }

    public Job(String major, String role) { // Corrected from 'roll' to 'role'
        this.major = major;
        this.role = role; // Corrected from 'roll' to 'role'
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getRole() { // Corrected from 'roll' to 'role'
        return role;
    }

    public void setRole(String role) { // Corrected from 'roll' to 'role'
        this.role = role;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", major='" + major + '\'' +
                ", role='" + role + '\'' + // Corrected from 'roll' to 'role'
                '}';
    }
}