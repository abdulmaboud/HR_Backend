package com.trt.HR.Repository;

import com.trt.HR.Model.Company.Employee;
import com.trt.HR.Model.Company.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findByName(String name);

    List<Employee> findByProjectId(Long projectId);

    List<Employee> findByJobId(Long jobId);

    List<Employee> findByContractId(Long contractId);

    Employee findById(long id);




}