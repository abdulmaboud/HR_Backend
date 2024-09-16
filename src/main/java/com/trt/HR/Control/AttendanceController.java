package com.trt.HR.Control;

import com.trt.HR.Model.Company.Attendance;
import com.trt.HR.Service.AttendanceService;
import com.trt.HR.Service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    private EmployeeService employeeService;




    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceService.saveAttendance(attendance);
        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
    }

    @GetMapping("/{employee_id}/{date}")
    public ResponseEntity<List<Attendance>> getAttendancesByEmployeeAndDate(
            @PathVariable("employee_id") Long employee_id,
            @PathVariable("date") LocalDateTime date) {

            List<Attendance> attendances = attendanceService.getAttendancesByEmployeeAndDate(employee_id, date);
            return ResponseEntity.ok(attendances);

    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Attendance>> getAttendancesByDate(@PathVariable("date") LocalDateTime date) {
        List<Attendance> attendances = attendanceService.getAttendancesByDate(date);
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<Attendance>> getAttendanceByEmployeeId(@PathVariable("id") Long id) {
        List<Attendance> attendances = attendanceService.getAttendancesByEmployeeId(id);
        return ResponseEntity.ok(attendances);

    }

}