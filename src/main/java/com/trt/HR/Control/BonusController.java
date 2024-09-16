package com.trt.HR.Control;

import com.trt.HR.Model.Complain.Bonus;
import com.trt.HR.Service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bonus")
public class BonusController {
    @Autowired
    private  BonusService bonusService;


    @GetMapping
    public List<Bonus> getAllBonuses() {
        return bonusService.getAllBonuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bonus> getBonusById(@PathVariable Long id) {
        return bonusService.getBonusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bonus> createBonus(@RequestBody Bonus bonus) {
        Bonus savedBonus = bonusService.saveBonus(bonus);
        return ResponseEntity.ok(savedBonus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBonus(@PathVariable Long id) {
        bonusService.deleteBonus(id);
        return ResponseEntity.noContent().build();
    }
}