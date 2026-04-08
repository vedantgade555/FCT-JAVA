package com.vedant.controller;

import com.vedant.Service.RestaurentService;
import com.vedant.Service.UserService;
import com.vedant.model.Restaurant;
import com.vedant.model.User;
import com.vedant.request.CreateRestaurentRequest;
import com.vedant.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Marks this class as REST API controller
@RequestMapping("/api/admin/restaurants") // Base URL for all APIs in this controller
public class AdminResraurantController {

    @Autowired
    private RestaurentService restaurentService; // Service for restaurant operations

    @Autowired
    private UserService userService; // Service for user-related operations

    // API to create a new restaurant
    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(
            @RequestBody CreateRestaurentRequest req, // Request body data
            @RequestHeader("Authorization") String jwt // JWT token from header
    ) throws Exception {

        // Get user from JWT token
        User user = userService.findUserByJwtToken(jwt);

        // Create restaurant using service
        Restaurant restaurant = restaurentService.createRestaurant(req, user);

        // Return response with status 200 OK
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    // API to update restaurant details
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @RequestBody CreateRestaurentRequest req, // Updated data
            @RequestHeader("Authorization") String jwt, // JWT token
            @PathVariable Long id // Restaurant ID from URL
    ) throws Exception {

        // Get user from JWT
        User user = userService.findUserByJwtToken(jwt);

        // Update restaurant
        Restaurant restaurant = restaurentService.updateRestaurant(id, req);

        // Return updated restaurant with status 201 CREATED
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    // API to delete a restaurant
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(
            @RequestHeader("Authorization") String jwt, // JWT token
            @PathVariable Long id // Restaurant ID
    ) throws Exception {

        // Get user from JWT
        User user = userService.findUserByJwtToken(jwt);

        // Delete restaurant
        restaurentService.deleteRestaurant(id);

        // Prepare success message
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Restaurant deleted successfully");

        // Return response
        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }

    // API to update restaurant status (open/close etc.)
    @PutMapping("/{id}/ststus")
    public ResponseEntity<Restaurant> updateRestaurantStatus(
            @RequestHeader("Authorization") String jwt, // JWT token
            @PathVariable Long id // Restaurant ID
    ) throws Exception {

        // Get user from JWT
        User user = userService.findUserByJwtToken(jwt);

        // Update status
        Restaurant restaurant = restaurentService.updateRestaurantStatus(id);

        // Return updated restaurant
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    // API to get restaurant by logged-in user
    @GetMapping("/user")
    public ResponseEntity<Restaurant> FindRestaurantByUserId(
            @RequestHeader("Authorization") String jwt // JWT token
    ) throws Exception {

        // Get user from JWT
        User user = userService.findUserByJwtToken(jwt);

        // Fetch restaurant using user ID
        Restaurant restaurant = restaurentService.getRestaurantByUserId(user.getId());

        // Return restaurant
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}