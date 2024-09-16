package com.trt.HR.Model.Company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trt.HR.Enums.Attend;
import com.trt.HR.Enums.Status;
import com.trt.HR.Model.Complain.Bonus;
import com.trt.HR.Model.Complain.Warning;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Employee")
public class Employee implements com.trt.HR.Interfaces.Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long salary;

    @ManyToOne
    @JoinColumn(name = "project_id")

    private Project project;

    @ManyToOne
    @JoinColumn(name = "job_id")

    private Job job;

    @ManyToOne
    @JoinColumn(name = "contract_id")

    private Contract contract;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public Employee() {
    }

    public Employee(Long id, Tenant tenant, String name, Long salary, Project project, Job job, Contract contract, Status status) {
        this.id = id;
        this.tenant = tenant;
        this.name = name;
        this.salary = salary;
        this.project = project;
        this.project.setMembersNo(this.project.getMembersNo() + 1);
        this.job = job;
        this.contract = contract;
        this.status = status;
    }







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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {

        this.project = project;

    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;

    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
        this.salary = contract != null ? contract.getSalaryPerYear() : this.salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void deduct(Long deduction) {
        if (deduction != null && deduction < this.salary) {
            this.salary -= deduction;
        }
    }

    public void Bonus(Long bonus) {
        if (bonus != null && bonus < this.salary) {
            this.salary += bonus;
        }
    }

    }




