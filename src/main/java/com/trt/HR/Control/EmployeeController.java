package com.trt.HR.Control;

import com.trt.HR.Enums.Attend;
import com.trt.HR.Model.Company.Employee;
import com.trt.HR.Model.Company.Job;
import com.trt.HR.Model.Company.Project;
import com.trt.HR.Model.Complain.Bonus;
import com.trt.HR.Model.Complain.Warning;
import com.trt.HR.Model.Exceptions.EmployeeDoesNotExistException;
import com.trt.HR.Model.Exceptions.EmployeeExistsException;
import com.trt.HR.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        try {
            Employee employee = employeeService.findEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (EmployeeDoesNotExistException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Optional<Employee>> getEmployeeByName(@PathVariable String name) {
        Optional<Employee> employee = employeeService.findEmployeeByName(name);
        return employee.isPresent() ? new ResponseEntity<>(employee, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<Employee>> getEmployeesByProject(@PathVariable Long projectId) {
        List<Employee> employees = employeeService.findEmployeesByProject(projectId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Employee>> getEmployeesByJob(@PathVariable Long jobId) {
        List<Employee> employees = employeeService.findEmployeesByJob(jobId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/contract/{contractId}")
    public ResponseEntity<List<Employee>> getEmployeesByContract(@PathVariable Long contractId) {
        List<Employee> employees = employeeService.findEmployeesByContract(contractId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/name/{name}/attendance")
    public ResponseEntity<Void> setAttendanceByName(@PathVariable String name, @RequestParam String date, @RequestParam Attend attendance) {
        try {
            LocalDateTime parsedDate = LocalDateTime.parse(date, DATE_FORMATTER);
            employeeService.setAttendanceByName(name, parsedDate, attendance);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EmployeeDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/deduct")
    public ResponseEntity<Void> deductSalary(@PathVariable Long id, @RequestBody Map<String, Long> payload) {
        try {
            Long amount = payload.get("deduction");  // Extract 'deduction' from request body
            if (amount == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            employeeService.deductSalary(id, amount);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmployeeDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/bonus")
    public ResponseEntity<Void> BonusSalary(@PathVariable Long id, @RequestBody Map<String, Long> payload) {
        try {
            Long amount = payload.get("bonus");  // Extract 'bonus' from request body
            if (amount == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            employeeService.BonusSalary(id, amount);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmployeeDoesNotExistException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        try {
            employeeService.deleteEmployeeById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/job/{id}")
    public ResponseEntity<Void> updateEmployeeJob(@PathVariable Long id, @RequestBody Job job)
            throws EmployeeDoesNotExistException, EmployeeExistsException {
        // Find the employee by ID
        Employee e = employeeService.findEmployeeById(id);

        // Check if the employee exists
        if (e == null) {
            throw new EmployeeDoesNotExistException();
        }

       employeeService.UpdateJob(job,id);

        // Return no content status to indicate successful update
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/project/{id}")
    public ResponseEntity<Void> updateEmployeeProject(@PathVariable Long id, @RequestBody Project project)
            throws EmployeeDoesNotExistException, EmployeeExistsException {
        // Find the employee by ID
        Employee e = employeeService.findEmployeeById(id);


        // Check if the employee exists
        if (e == null) {
            throw new EmployeeDoesNotExistException();
        }

        employeeService.UpdateProject(project,id);

        // Return no content status to indicate successful update
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}