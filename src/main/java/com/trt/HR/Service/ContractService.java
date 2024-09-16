package com.trt.HR.Service;

import com.trt.HR.Model.Company.Contract;
import com.trt.HR.Repository.ContractRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public Contract saveContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public List<Contract> findContractsByStart(Date start) {
        return contractRepository.findByStart(start);
    }

    public List<Contract> findContractsByEnd(Date end) {
        return contractRepository.findByEnd(end);
    }

    public List<Contract> findContractsByDuration(int duration) {
        return contractRepository.findByDuration(duration);
    }

    public List<Contract> findContractsBySalary(long salaryperyear) {
        return contractRepository.findBySalaryperyear(salaryperyear);
    }

    public Optional<Contract> findContractById(Long id) {
        return (contractRepository.findById(id));
    }

    public List<Contract> findAllContracts() {
        return contractRepository.findAll();
    }


    @Transactional
    public void deleteContractById(Long id) {
        contractRepository.deleteContractById(id);
    }
}