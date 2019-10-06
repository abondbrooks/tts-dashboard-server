package tts.dashboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tts.dashboard.entities.Category;
import tts.dashboard.repositories.CategoryRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    Optional<Category> getCategoryById(@PathVariable int id) {
        return categoryRepository.findById(id);
    }

    @PostMapping("/categories/post")
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable int id, @Valid @RequestBody Category category){
        category.setId(id);
        return categoryRepository.save(category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategoryById(@PathVariable int id) {
        categoryRepository.deleteById(id);
    }
}
