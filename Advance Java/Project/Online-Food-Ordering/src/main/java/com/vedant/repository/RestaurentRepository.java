package com.vedant.repository;

import com.vedant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks this interface as a Spring Data Repository
public interface RestaurentRepository extends JpaRepository<Restaurant, Long> {

    // Custom JPQL query to search restaurants by name OR cuisine type (case-insensitive)
    @Query("SELECT r FROM Restaurant r " +
            "WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(r.cuisineType) LIKE LOWER(CONCAT('%', :query, '%'))")

    List<Restaurant> findSearchQuery(String query);
    // Returns list of restaurants matching the search keyword

    // Spring Data JPA automatically generates query:
    // SELECT * FROM restaurant WHERE owner_id = ?
    Restaurant findByOwnerId(Long userId);

}