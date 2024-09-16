package com.trt.HR.Model.Complain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.trt.HR.Model.Company.Employee;
import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Warning.class, name = "warning"),
        @JsonSubTypes.Type(value = Bonus.class, name = "bonus")
})
public abstract class Complain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private Date date;
    private String reason;


    // Constructors, getters, and setters
    public Complain() {
    }

    public Complain(String subject, Date date, String reason, Employee employee) {
        this.subject = subject;
        this.date = date;
        this.reason = reason;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}