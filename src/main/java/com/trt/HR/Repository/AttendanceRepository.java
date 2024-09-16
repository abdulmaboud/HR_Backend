package com.trt.HR.Repository;

import com.trt.HR.Model.Company.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // Custom query method to find attendance by employee and date
    List<Attendance> findByEmployeeIdAndDate(Long employee_id, LocalDateTime date);

    List<Attendance> findByDate(LocalDateTime date);

    List<Attendance> findByEmployeeId(Long employee_id);
}