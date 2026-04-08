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

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminResraurantController {

    @Autowired
    private RestaurentService restaurentService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody CreateRestaurentRequest req, @RequestHeader("Authorization") String jwt) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurentService.createRestaurant(req,user);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody CreateRestaurentRequest req, @RequestHeader("Authorization") String jwt,@PathVariable Long id) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurentService.updateRestaurant(id,req);

        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(@RequestHeader("Authorization") String jwt, @PathVariable Long id) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        restaurentService.deleteRestaurant(id);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Restaurant deleted successfully");

        return new ResponseEntity<>(messageResponse, HttpStatus.OK);
    }


}
