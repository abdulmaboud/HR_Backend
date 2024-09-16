package com.trt.HR.Interfaces;

import jakarta.persistence.Entity;

import java.util.Date;


public interface Request {

    Date getDate();

    void setDate(Date date);

    String getReason();

    void setReason(String reason);

    String getSubject();

}