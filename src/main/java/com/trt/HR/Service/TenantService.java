package com.trt.HR.Service;

import com.trt.HR.Model.Company.Tenant;
import com.trt.HR.Repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    public Optional<Tenant> findTenantById(Long id) {
        return tenantRepository.findById(id);
    }

    public Optional<Tenant> findTenantByName(String name) {
        return tenantRepository.findByName(name);
    }

    public Optional<Tenant> findTenantByEmail(String email) {
        return tenantRepository.findByEmail(email);
    }

    public Optional<Tenant> findTenantByDomain(String domain) {
        return tenantRepository.findByDomain(domain);
    }

    public List<Tenant> findAllTenants() {
        return tenantRepository.findAll();
    }

    public Tenant updateTenant(Long id, Tenant tenant)  {
        tenant.setId(id);
        return tenantRepository.save(tenant);
    }

    public void deleteTenant(Long id) {
        tenantRepository.deleteById(id);
    }
}