package com.vedant.controller;

import com.vedant.Service.RestaurentService;
import com.vedant.Service.UserService;
import com.vedant.dto.RestaurantDto;
import com.vedant.model.Restaurant;
import com.vedant.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurentService restaurentService;

    @Autowired
    private UserService userService;

    // 1. Search restaurants by keyword
    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(
            @RequestHeader("Authorization") String jwt,
            @RequestParam String keyword
    ) throws Exception {
        // Authenticate user (optional based on your business logic, but good for security)
        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurants = restaurentService.searchRestaurant(keyword);
        return new ResponseEntity<>(restaurants, HttpStatus.OK); // Changed to OK
    }

    // 2. Get all restaurants (Changed mapping to root to avoid conflict)
    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurants(
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        List<Restaurant> restaurants = restaurentService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    // 3. Get a specific restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById( // Changed return type to a single Restaurant
                                                         @RequestHeader("Authorization") String jwt,
                                                         @PathVariable Long id
    ) throws Exception {
        Restaurant restaurant = restaurentService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    // 4. Add a restaurant to user favorites
    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto> addToFavorites( // Changed return type to RestaurantDto
                                                         @RequestHeader("Authorization") String jwt,
                                                         @PathVariable Long id
    ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        RestaurantDto restaurantDto = restaurentService.addToFavorites(id, user);
        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }
}