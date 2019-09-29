package tts.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tts.dashboard.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
