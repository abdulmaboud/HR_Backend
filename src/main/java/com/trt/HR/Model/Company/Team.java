package com.trt.HR.Model.Company;

import com.trt.HR.Model.Exceptions.EmployeeExistsException;
import com.trt.HR.Model.Exceptions.ProjectExistsException;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "team_employees",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "team_projects",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects = new ArrayList<>();

    @Column(name = "employee_no")
    private int employeeNo;

    @Column(name = "project_no")
    private int projectsNo;

    // Constructors
    public Team() {}

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, List<Employee> employees, List<Project> projects) {
        this.name = name;
        this.employees = employees != null ? employees : new ArrayList<>();
        this.projects = projects != null ? projects : new ArrayList<>();
        this.updateEmployeeNo();
        this.updateProjectNo();
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees != null ? employees : new ArrayList<>();
        this.updateEmployeeNo();
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects != null ? projects : new ArrayList<>();
        this.updateProjectNo();
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
    }

    public int getProjectsNo() {
        return projectsNo;
    }

    public void setProjectsNo(int projectsNo) {
        this.projectsNo = projectsNo;
    }

    // Methods to add/remove employees and projects
    public void addEmployee(Employee employee) {
        if (!this.employees.contains(employee)) {
            this.employees.add(employee);
            this.updateEmployeeNo();
        }
    }

    public Optional<Employee> getEmployee(Long id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst();
    }

    public void removeEmployee(Employee employee) {
        if (this.employees.remove(employee)) {
            this.updateEmployeeNo();
        }
    }

    public void addProject(Project project) {
        if (!this.projects.contains(project)) {
            this.projects.add(project);
            this.updateProjectNo();
        }
    }

    public Optional<Project> getProject(Long id) {
        return projects.stream().filter(project -> project.getId().equals(id)).findFirst();
    }

    public void removeProject(Project project) {
        if (this.projects.remove(project)) {
            this.updateProjectNo();
        }
    }

    public void updateEmployeeNo() {
        this.employeeNo = this.employees.size();
    }

    public void updateProjectNo() {
        this.projectsNo = this.projects.size();
    }
}