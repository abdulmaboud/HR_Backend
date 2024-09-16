package com.trt.HR.Control;

import com.trt.HR.Model.Complain.Warning;
import com.trt.HR.Service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warning")
public class WarningController {

    private final WarningService warningService;

    @Autowired
    public WarningController(WarningService warningService) {
        this.warningService = warningService;
    }

    @GetMapping
    public List<Warning> getAllWarnings() {
        return warningService.getAllWarnings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warning> getWarningById(@PathVariable Long id) {
        return warningService.getWarningById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Warning> createWarning(@RequestBody Warning warning) {
        Warning savedWarning = warningService.saveWarning(warning);
        return ResponseEntity.ok(savedWarning);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarning(@PathVariable Long id) {
        warningService.deleteWarning(id);
        return ResponseEntity.noContent().build();
    }
}