package com.trt.HR.Service;

import com.trt.HR.Model.Company.Employee;
import com.trt.HR.Model.Company.Project;
import com.trt.HR.Model.Company.Team;
import com.trt.HR.Model.Exceptions.EmployeeExistsException;
import com.trt.HR.Model.Exceptions.ProjectExistsException;
import com.trt.HR.Repository.EmployeeRepository;
import com.trt.HR.Repository.ProjectRepository;
import com.trt.HR.Repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Team createTeam(String name) {
        Team team = new Team(name);
        return teamRepository.save(team);
    }

    @Transactional
    public Team addEmployeeToTeam(Long teamId, Long employeeId) throws EmployeeExistsException {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();

            // Fetch employee by employeeId
            Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
            if (employeeOptional.isPresent()) {
                Employee employee = employeeOptional.get();
                team.addEmployee(employee);
                return teamRepository.save(team);
            } else {
                throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
            }
        } else {
            throw new IllegalArgumentException("Team not found with ID: " + teamId);
        }
    }

    @Transactional
    public Team addProjectToTeam(Long teamId, Long projectId) throws ProjectExistsException {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();

            // Fetch project by projectId
            Optional<Project> projectOptional = projectRepository.findById(projectId);
            if (projectOptional.isPresent()) {
                Project project = projectOptional.get();
                team.addProject(project);
                return teamRepository.save(team);
            } else {
                throw new IllegalArgumentException("Project not found with ID: " + projectId);
            }
        } else {
            throw new IllegalArgumentException("Team not found with ID: " + teamId);
        }
    }

    @Transactional
    public List<Employee> getTeamEmployees(Long teamId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        return teamOptional.map(Team::getEmployees).orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + teamId));
    }

    @Transactional
    public List<Project> getTeamProjects(Long teamId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        return teamOptional.map(Team::getProjects).orElseThrow(() -> new IllegalArgumentException("Team not found with ID: " + teamId));
    }

    @Transactional
    public void removeEmployeeFromTeam(Long teamId, Long employeeId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            Optional<Employee> employeeOptional = team.getEmployees().stream().filter(e -> e.getId().equals(employeeId)).findFirst();
            employeeOptional.ifPresent(team::removeEmployee);
            teamRepository.save(team);
        } else {
            throw new IllegalArgumentException("Team not found with ID: " + teamId);
        }
    }

    @Transactional
    public void removeProjectFromTeam(Long teamId, Long projectId) {
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if (teamOptional.isPresent()) {
            Team team = teamOptional.get();
            Optional<Project> projectOptional = team.getProjects().stream().filter(p -> p.getId().equals(projectId)).findFirst();
            projectOptional.ifPresent(team::removeProject);
            teamRepository.save(team);
        } else {
            throw new IllegalArgumentException("Team not found with ID: " + teamId);
        }
    }

    public Optional<Team> findTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}