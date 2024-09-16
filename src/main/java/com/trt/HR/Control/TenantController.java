package com.trt.HR.Control;

import com.trt.HR.Model.Company.Tenant;
import com.trt.HR.Service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping
    public ResponseEntity<Tenant> createTenant(@RequestBody Tenant tenant) {
        Tenant savedTenant = tenantService.saveTenant(tenant);
        return new ResponseEntity<>(savedTenant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> getTenantById(@PathVariable Long id) {
        Optional<Tenant> tenant = tenantService.findTenantById(id);
        return tenant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Tenant> getTenantByName(@PathVariable String name) {
        Optional<Tenant> tenant = tenantService.findTenantByName(name);
        return tenant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Tenant> getTenantByEmail(@PathVariable String email) {
        Optional<Tenant> tenant = tenantService.findTenantByEmail(email);
        return tenant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/domain/{domain}")
    public ResponseEntity<Tenant> getTenantByDomain(@PathVariable String domain) {
        Optional<Tenant> tenant = tenantService.findTenantByDomain(domain);
        return tenant.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public ResponseEntity<List<Tenant>> getAllTenants() {
        List<Tenant> tenants = tenantService.findAllTenants();
        return ResponseEntity.ok(tenants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tenant> updateTenant(@PathVariable Long id, @RequestBody Tenant tenant) {
            Tenant updatedTenant = tenantService.updateTenant(id, tenant);
            return ResponseEntity.ok(updatedTenant);
        }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTenant(@PathVariable Long id) {

            tenantService.deleteTenant(id);
            return ResponseEntity.noContent().build();}


    }
