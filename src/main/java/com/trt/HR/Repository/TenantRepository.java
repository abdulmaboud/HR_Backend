package com.trt.HR.Repository;

import com.trt.HR.Model.Company.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

    // Custom query method to find tenant by name
    Optional<Tenant> findByName(String name);

    // Custom query method to find tenant by email
    Optional<Tenant> findByEmail(String email);

    // Custom query method to find tenant by domain
    Optional<Tenant> findByDomain(String domain);
}