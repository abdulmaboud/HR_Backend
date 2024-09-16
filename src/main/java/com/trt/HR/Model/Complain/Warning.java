package com.trt.HR.Model.Complain;

import com.trt.HR.Model.Company.Employee;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "warning")
public class Warning extends Complain {
    @Column(name = "deduction")
    private Long deduction;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Warning() {}

    public Warning(Long deduction) {
        this.deduction = deduction;
    }

    public Warning(String subject, Date date, String reason, Employee employee, Long deduction) {
        super(subject, date, reason, employee);
        this.deduction = deduction;
    }

    public Warning(Long deduction, Employee employee) {
        this.deduction = deduction;
        this.employee = employee;
    }

    public Warning(String subject, Date date, String reason, Employee employee, Long deduction, Employee employee1) {
        super(subject, date, reason, employee);
        this.deduction = deduction;
        this.employee = employee1;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Warning(String subject, Date date, String reason, Long deduction, Employee employee) {
        super(subject, date, reason, employee);
        this.deduction = deduction;
    }


    public Long getDeduction() {
        return deduction;
    }

    public void setDeduction(Long deduction) {
        this.deduction = deduction;
    }
}