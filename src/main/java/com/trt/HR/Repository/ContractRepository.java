package com.trt.HR.Repository;

import com.trt.HR.Model.Company.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    // Custom query method to find contracts by start date
    List<Contract> findByStart(Date start);

    // Custom query method to find contracts by end date
    List<Contract> findByEnd(Date end);

    // Custom query method to find contracts by duration
    List<Contract> findByDuration(int duration);

    // Custom query method to find contracts by salary per year
    List<Contract> findBySalaryperyear(long salaryperyear);

    void deleteContractById(Long id);
}