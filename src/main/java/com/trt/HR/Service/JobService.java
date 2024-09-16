package com.trt.HR.Service;

import com.trt.HR.Model.Company.Job;
import com.trt.HR.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Save or update a Job
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    // Find a Job by its ID
    public Optional<Job> findJobById(Long id) {
        return jobRepository.findById(id);
    }

    // Find all Jobs
    public List<Job> findAllJobs() {
        return jobRepository.findAll();
    }

    // Delete a Job by its ID
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}