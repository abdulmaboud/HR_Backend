package com.trt.HR.Model.Complain;

import com.trt.HR.Model.Company.Employee;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bonus")
public class Bonus extends Complain {
    @Column(name = "bonus")
    private Long bonus;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Bonus() {
    }

    public Bonus(Long bonus) {
        this.bonus = bonus;
    }

    public Bonus(Long bonus, Employee employee) {
        this.bonus = bonus;
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Bonus(String subject, Date date, String reason, Employee employee, Long bonus, Employee employee1) {
        super(subject, date, reason, employee);
        this.bonus = bonus;
        this.employee = employee1;
    }

    public Bonus(String subject, Date date, String reason, Employee employee, Long bonus) {
        super(subject, date, reason, employee);
        this.bonus = bonus;
    }


    public Bonus(String subject, Date date, String reason, Long bonus, Employee employee) {
        super(subject, date, reason, employee);
        this.bonus = bonus;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }


}