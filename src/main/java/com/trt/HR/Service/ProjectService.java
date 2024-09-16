package com.trt.HR.Service;

import com.trt.HR.Model.Company.Project;
import com.trt.HR.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> findProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }





}