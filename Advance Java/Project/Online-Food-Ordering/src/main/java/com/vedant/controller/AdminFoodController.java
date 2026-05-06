package com.vedant.controller;

import com.vedant.Service.FoodService;
import com.vedant.Service.RestaurentService;
import com.vedant.Service.UserService;
import com.vedant.model.Food;
import com.vedant.model.Restaurant;
import com.vedant.model.User;
import com.vedant.request.CreateFoodRequest;
import com.vedant.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurentService restaurentService;


    @PostMapping
    public ResponseEntity<Food> createFood(
            @RequestBody CreateFoodRequest req,
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurentService.findRestaurantById(req.getRestaurantId());

        Food food = foodService.createFood(req, req.getCategory(), restaurant);

        return ResponseEntity.status(HttpStatus.CREATED).body(food);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws Exception
    {
         User user = userService.findUserByJwtToken(jwt);
         foodService.deleteFood(id);

        MessageResponse res =  new MessageResponse();
        res.setMessage("Food has been deleted successfully");

         return new  ResponseEntity<>(res,HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvaliabilityStatus(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws Exception
    {
        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.updateAvaliabilityStatus(id);

        return new  ResponseEntity<>(food,HttpStatus.CREATED);
    }




}
