package com.trt.HR.Service;

import com.trt.HR.Enums.Attend;
import com.trt.HR.Model.Company.Attendance;
import com.trt.HR.Model.Company.Employee;
import com.trt.HR.Model.Company.Job;
import com.trt.HR.Model.Company.Project;
import com.trt.HR.Model.Complain.Bonus;
import com.trt.HR.Model.Complain.Warning;
import com.trt.HR.Model.Exceptions.EmployeeDoesNotExistException;
import com.trt.HR.Model.Exceptions.EmployeeExistsException;
import com.trt.HR.Repository.EmployeeRepository;
import com.trt.HR.Repository.AttendanceRepository;
import com.trt.HR.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Employee saveEmployee(Employee employee) throws EmployeeExistsException {
        if (employeeRepository.findByName(employee.getName()).isPresent()) {
            throw new EmployeeExistsException();
        }
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> findEmployeesByProject(Long projectId) {
        return employeeRepository.findByProjectId(projectId);
    }

    public List<Employee> findEmployeesByJob(Long jobId) {
        return employeeRepository.findByJobId(jobId);
    }

    public List<Employee> findEmployeesByContract(Long contractId) {
        return employeeRepository.findByContractId(contractId);
    }

    public Employee findEmployeeById(Long id) throws EmployeeDoesNotExistException {
        return employeeRepository.findById(id)
                .orElseThrow(EmployeeDoesNotExistException::new);
    }

    public List<Employee> findAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Transactional
    public void setAttendanceById(Long employeeId, LocalDateTime date, Attend attendance) throws EmployeeDoesNotExistException {
        Employee employee = findEmployeeById(employeeId);
        Attendance newAttendance = new Attendance(date, attendance, employee);
        attendanceRepository.save(newAttendance);
    }

    @Transactional
    public void setAttendanceByName(String name, LocalDateTime date, Attend attendance) throws EmployeeDoesNotExistException {
        Employee employee = findEmployeeByName(name)
                .orElseThrow(EmployeeDoesNotExistException::new);
        Attendance newAttendance = new Attendance(date, attendance, employee);
        attendanceRepository.save(newAttendance);
    }

    @Transactional
    public void BonusSalary(Long employeeId, Long amount) throws EmployeeDoesNotExistException {
        Employee employee = findEmployeeById(employeeId);
        employee.Bonus(amount);
        employeeRepository.save(employee);
    }



    @Transactional
    public void deductSalary(Long employeeId, Long amount) throws EmployeeDoesNotExistException {
        Employee employee = findEmployeeById(employeeId);
        employee.deduct(amount);
        employeeRepository.save(employee);
    }




    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public void UpdateJob(Job job,Long employeeId) {
        Employee e = employeeRepository.findById(employeeId).get();
        e.setJob(job);
        employeeRepository.save(e);
    }

    public void UpdateProject(Project newProject, Long employeeId) {
        // Fetch the employee
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));

        // Retrieve the current project of the employee
        Project oldProject = employee.getProject();

        if (oldProject != null) {
            // Decrement membersNo for the old project
            oldProject.setMembersNo(oldProject.getMembersNo() - 1);
            projectRepository.save(oldProject);
        }

        // Set the new project to the employee
        employee.setProject(newProject);

        // Increment membersNo for the new project
        newProject.setMembersNo(newProject.getMembersNo() + 1);
        projectRepository.save(newProject); // Save the new project

        // Save the updated employee
        employeeRepository.save(employee);
    }
    }


