package com.trt.HR.Service;

import com.trt.HR.Model.Complain.Warning;
import com.trt.HR.Repository.WarningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarningService {

    private final WarningRepository warningRepository;

    @Autowired
    public WarningService(WarningRepository warningRepository) {
        this.warningRepository = warningRepository;
    }

    public List<Warning> getAllWarnings() {
        return warningRepository.findAll();
    }

    public Optional<Warning> getWarningById(Long id) {
        return warningRepository.findById(id);
    }

    public Warning saveWarning(Warning warning) {
        return warningRepository.save(warning);
    }

    public void deleteWarning(Long id) {
        warningRepository.deleteById(id);
    }
}