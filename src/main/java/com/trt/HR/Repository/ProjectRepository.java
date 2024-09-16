package com.trt.HR.Repository;

import com.trt.HR.Model.Company.Employee;
import com.trt.HR.Model.Company.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}