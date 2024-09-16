package com.trt.HR.Service;

import com.trt.HR.Model.Company.Attendance;
import com.trt.HR.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;



    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendancesByEmployeeAndDate(Long employee_id, LocalDateTime date) {

        return attendanceRepository.findByEmployeeIdAndDate(employee_id, date);
    }
    public List<Attendance> getAttendancesByDate(LocalDateTime date) {
        return attendanceRepository.findByDate(date);
    }
    public void deleteAttendance(Long attendance_id) {
        attendanceRepository.deleteById(attendance_id);
    }


    public List<Attendance> getAttendancesByEmployeeId(Long employee_id) {
        return attendanceRepository.findByEmployeeId(employee_id);
    }
}