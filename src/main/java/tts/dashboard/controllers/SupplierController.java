package tts.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tts.dashboard.entities.Supplier;
import tts.dashboard.repositories.SupplierRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class SupplierController {
    @Autowired
    SupplierRepository supplierRepository;

    @GetMapping("/suppliers")
    public List<Supplier> getSupplier() {
        return supplierRepository.findAll();
    }

    @GetMapping("/suppliers/{id}")
    Optional<Supplier> getSupplierById(@PathVariable int id) {
        return supplierRepository.findById(id);
    }

    @PostMapping("/suppliers/post")
    public Supplier createSupplier(@Valid @RequestBody Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @PutMapping("/suppliers/{id}")
    public Supplier updateSupplier(@PathVariable int id, @Valid @RequestBody Supplier supplier){
        supplier.setId(id);
        return supplierRepository.save(supplier);
    }

    @DeleteMapping("/suppliers/{id}")
    public void deleteSupplierById(@PathVariable int id) {
        supplierRepository.deleteById(id);
    }
}
