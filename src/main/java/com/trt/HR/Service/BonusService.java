package com.trt.HR.Service;

import com.trt.HR.Model.Complain.Bonus;
import com.trt.HR.Repository.BonusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BonusService {

    private final BonusRepository bonusRepository;

    @Autowired
    public BonusService(BonusRepository bonusRepository) {
        this.bonusRepository = bonusRepository;
    }

    public List<Bonus> getAllBonuses() {
        return bonusRepository.findAll();
    }

    public Optional<Bonus> getBonusById(Long id) {
        return bonusRepository.findById(id);
    }

    public Bonus saveBonus(Bonus bonus) {
        return bonusRepository.save(bonus);
    }

    public void deleteBonus(Long id) {
        bonusRepository.deleteById(id);
    }
}