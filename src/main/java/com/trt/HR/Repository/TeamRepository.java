package com.trt.HR.Repository;

import com.trt.HR.Model.Company.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    // Additional query methods can be defined here if needed
}