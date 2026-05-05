package com.vedant.Service;

import com.vedant.model.Category;
import com.vedant.model.Food;
import com.vedant.model.Restaurant;
import com.vedant.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantsFood(Long restaurantId, boolean isVegiterian, boolean isNonveg, boolean isSeasonal, String foodCategory);

    public List<Food> searchFood(String keyWord);

    public Food findFoodById(Long id);

    public Food updateAvaliabilityStatus(long id) throws Exception;


}
