package tts.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tts.dashboard.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
