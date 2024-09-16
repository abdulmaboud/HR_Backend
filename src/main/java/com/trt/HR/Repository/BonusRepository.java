package com.trt.HR.Repository;

import com.trt.HR.Model.Complain.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonusRepository extends JpaRepository<Bonus, Long> {
    // Additional query methods (if needed) can be defined here
}