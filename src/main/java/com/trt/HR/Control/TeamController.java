package com.trt.HR.Control;

import com.trt.HR.Model.Company.Employee;
import com.trt.HR.Model.Company.Project;
import com.trt.HR.Model.Company.Team;
import com.trt.HR.Model.Exceptions.EmployeeExistsException;
import com.trt.HR.Model.Exceptions.ProjectExistsException;
import com.trt.HR.Service.EmployeeService;
import com.trt.HR.Service.ProjectService;
import com.trt.HR.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private  TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @PostMapping("/create")
    public ResponseEntity<Team> createTeam(@RequestParam String name) {
        Team createdTeam = teamService.createTeam(name);
        return ResponseEntity.ok(createdTeam);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Optional<Team> team = teamService.findTeamById(id);
        return team.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.findAllTeams();
        return ResponseEntity.ok(teams);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{teamId}/Employee/{employeeId}")
    public ResponseEntity<String> addEmployeeToTeam(@PathVariable Long teamId, @PathVariable Long employeeId) {
        try {
            teamService.addEmployeeToTeam(teamId, employeeId);
            return ResponseEntity.ok("Employee added successfully.");
        } catch (EmployeeExistsException e) {
            return ResponseEntity.badRequest().body("Employee already exists in the team.");
        }
    }

    @PostMapping("/{teamId}/Project/{projectId}")
    public ResponseEntity<String> addProjectToTeam(@PathVariable Long teamId, @PathVariable Long projectId) {
        try {
            teamService.addProjectToTeam(teamId, projectId);
            return ResponseEntity.ok("Project added successfully.");
        } catch (ProjectExistsException e) {
            return ResponseEntity.badRequest().body("Project already exists in the team.");
        }
    }




    @PostMapping("/{teamId}/addEmployeeList")
    public ResponseEntity<String> addProjectToTeam(@PathVariable Long teamId, @RequestBody List<Long>employees) {
        for (int i = 0; i < employees.size(); i++) {
            try {
                this.teamService.addEmployeeToTeam(teamId, employees.get(i));}

             catch (EmployeeExistsException e) {
                return ResponseEntity.badRequest().body("Employee already exists in the team.");
            }

        }return ResponseEntity.ok("Project added successfully.");
    }

    @PostMapping("/{teamId}/addProjectList")
    public ResponseEntity<String> addListProjectToTeam(@PathVariable Long teamId, @RequestBody List<Long>projects) {
        for (int i = 0; i < projects.size(); i++) {
            try {
                this.teamService.addProjectToTeam(teamId, projects.get(i));

            } catch (ProjectExistsException e) {
                return ResponseEntity.badRequest().body("Project already exists in the team.");
            }

        }return ResponseEntity.ok("Project added successfully.");
    }
    @DeleteMapping("/{teamId}/Employee/{employeeId}")
    public ResponseEntity<String> removeEmployeeFromTeam(@PathVariable Long teamId, @PathVariable Long employeeId) {
        teamService.removeEmployeeFromTeam(teamId, employeeId);
        return ResponseEntity.ok("Employee removed successfully.");
    }

    @DeleteMapping("/{teamId}/Project/{projectId}")
    public ResponseEntity<String> removeProjectFromTeam(@PathVariable Long teamId, @PathVariable Long projectId) {
        teamService.removeProjectFromTeam(teamId, projectId);
        return ResponseEntity.ok("Project removed successfully.");
    }
}