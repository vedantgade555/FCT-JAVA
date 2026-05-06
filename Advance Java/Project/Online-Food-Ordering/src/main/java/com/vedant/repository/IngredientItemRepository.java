package com.vedant.repository;

import com.vedant.model.IngridientsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientItemRepository extends JpaRepository<IngridientsItem, Long> {
    List<IngridientsItem> findByRestaurantId(Long id);
}
