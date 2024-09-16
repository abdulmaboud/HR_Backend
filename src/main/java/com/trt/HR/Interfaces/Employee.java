package com.trt.HR.Interfaces;


import com.trt.HR.Enums.Attend;
import com.trt.HR.Model.Company.Attendance;
import com.trt.HR.Model.Company.Contract;
import com.trt.HR.Model.Company.Job;
import com.trt.HR.Model.Company.Project;
import java.time.LocalDateTime;


public interface Employee {
     String getName();
   void setName(String name);
   Long getSalary();
   void setSalary(Long salary);
   Job getJob();
     void setJob(Job job);
     Contract getContract();
     void setContract(Contract cont);
     Project getProject();
     void setProject(Project proj);

}
