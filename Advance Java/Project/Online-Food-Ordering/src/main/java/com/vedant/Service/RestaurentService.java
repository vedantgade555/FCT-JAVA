package com.vedant.Service;

import com.vedant.dto.RestaurantDto;
import com.vedant.model.Restaurant;
import com.vedant.model.User;
import com.vedant.request.CreateRestaurentRequest;

import java.util.List;

public interface RestaurentService {
    public Restaurant createRestaurant(CreateRestaurentRequest req, User user);

    public Restaurant updateRestaurant(Long restaurentId, CreateRestaurentRequest updateRestaurent) throws Exception;

    public void deleteRestaurant(Long restaurentId) throws Exception;

    public List<Restaurant> getAllRestaurants() throws Exception;

    public List<Restaurant> searchRestaurant(String keyword);

    public Restaurant findRestaurantById(Long restaurentId) throws Exception;

    public Restaurant getRestaurantByUserId(Long userId) throws Exception;

    public RestaurantDto addToFavorites(Long restaurentId, User user) throws Exception;

    public Restaurant updateRestaurantStatus(Long id)  throws Exception;

}
