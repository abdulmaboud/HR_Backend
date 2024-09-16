package com.trt.HR.Control;

import com.trt.HR.Model.Company.Contract;
import com.trt.HR.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    @Autowired
    private ContractService contractService;


    @PostMapping
    public Contract createContract(
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end,
            @RequestParam("duration") int duration,
            @RequestParam("salaryPerYear") long salaryPerYear) {

        // Create a new Contract object
        Contract contract = new Contract();
        contract.setStart(start);
        contract.setEnd(end);
        contract.setDuration(duration);
        contract.setSalaryPerYear(salaryPerYear);

        // Save the contract using the service
        return contractService.saveContract(contract);
    }

    @GetMapping("/start/{start}")
    public List<Contract> getContractsByStart(@PathVariable Date start) {
        return contractService.findContractsByStart(start);
    }

    @GetMapping("/end/{end}")
    public List<Contract> getContractsByEnd(@PathVariable Date end) {
        return contractService.findContractsByEnd(end);
    }

    @GetMapping("/duration/{duration}")
    public List<Contract> getContractsByDuration(@PathVariable int duration) {
        return contractService.findContractsByDuration(duration);
    }

    @GetMapping("/salary/{salaryperyear}")
    public List<Contract> getContractsBySalary(@PathVariable long salaryperyear) {
        return contractService.findContractsBySalary(salaryperyear);
    }

    @GetMapping
    public List<Contract> getAllContracts() {
        return contractService.findAllContracts();}

    @DeleteMapping("/delete/{id}")
    public void deleteContract(@PathVariable Long id) {
         contractService.deleteContractById(id);
    }




}