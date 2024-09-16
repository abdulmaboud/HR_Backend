
package com.trt.HR.Repository;

import com.trt.HR.Model.Complain.Warning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarningRepository extends JpaRepository<Warning, Long> {
    // Additional query methods (if needed) can be defined here
}