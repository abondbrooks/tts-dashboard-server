package tts.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tts.dashboard.entities.Product;
import tts.dashboard.repositories.ProductRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    Optional<Product> getProductById(@PathVariable int id) {
        return productRepository.findById(id);
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @Valid @RequestBody Product product){
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable int id) {
        productRepository.deleteById(id);
    }
}
