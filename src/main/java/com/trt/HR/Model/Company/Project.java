package com.trt.HR.Model.Company;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;
    private String name;
    private Date launch;
    private Date deadline;

    @Column(name = "members_no")
    private int membersNo;
    // Constructors, getters, and setters
    public Project() {
    }

    public Project(String name, Date launch, Date deadline) {
        this.name = name;
        this.launch = launch;
        this.deadline = deadline;
        this.membersNo = 0;
    }

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

    public int getMembersNo() {
        return membersNo;
    }

    public void setMembersNo(int membersNo) {
        this.membersNo = membersNo;
    }

    public Date getLaunch() {
        return launch;
    }

    public void setLaunch(Date launch) {
        this.launch = launch;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", membersNo=" + membersNo +
                ", launch=" + launch +
                ", deadline=" + deadline +
                '}';
    }


}
