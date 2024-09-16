package com.trt.HR.Model.Company;

import com.trt.HR.Enums.Attend;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
@Entity
@Table(name = "Attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendance_id")
    private Long id;

    @Column(name = "attendance_date")
    private LocalDateTime date;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Attend attendance;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Constructors, getters, and setters
    public Attendance() {
    }

    public Attendance(LocalDateTime date, Attend attendance, Employee employee) {
        this.date = date;
        this.attendance = attendance;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Attend isAttendance() {
        return attendance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Attend getAttendance() {
        return attendance;
    }

    public void setAttendance(Attend attendance) {
        this.attendance = attendance;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}