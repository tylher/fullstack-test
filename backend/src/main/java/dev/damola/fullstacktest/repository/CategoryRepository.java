package dev.damola.fullstacktest.repository;

import dev.damola.fullstacktest.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
