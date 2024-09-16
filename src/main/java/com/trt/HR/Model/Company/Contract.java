package com.trt.HR.Model.Company;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name = "Contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;

    private Date start;
    private Date end;
    private int duration;
    @Column(name = "salary_per_year")
    private long salaryperyear;

    // Constructors, getters, and setters
    public Contract() {
    }

    public Contract(Date start, Date end, int duration, long salaryperyear) {
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.salaryperyear = salaryperyear;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getSalaryPerYear() {
        return salaryperyear;
    }

    public void setSalaryPerYear(long salaryperyear) {
        this.salaryperyear = salaryperyear;
    }

    public long getSalaryperyear() {
        return salaryperyear;
    }

    public void setSalaryperyear(long salaryperyear) {
        this.salaryperyear = salaryperyear;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", duration=" + duration +
                ", salaryperyear=" + salaryperyear +
                '}';
    }
}