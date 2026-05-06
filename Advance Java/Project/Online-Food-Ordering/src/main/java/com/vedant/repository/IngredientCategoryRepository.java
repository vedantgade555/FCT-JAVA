package com.vedant.repository;

import com.vedant.model.IngridientsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientCategoryRepository extends JpaRepository<IngridientsCategory, Long> {
    List<IngridientsCategory> findByRestaurantId(Long id);
}
