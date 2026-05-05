package com.vedant.Service;

import com.vedant.model.Category;
import com.vedant.model.Food;
import com.vedant.model.Restaurant;
import com.vedant.repository.FoodRepository;
import com.vedant.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {
        Food food = new Food();
        food.setFoodCategory(category);
        food.setRestaurant(restaurant);
        food.setDescription(req.getDescription());
        food.setImages(req.getImages());
        food.setName(req.getName());
        food.setPrice(req.getPrice());
        food.setIngridientsItems(req.getIngridients());
        food.setSessonal(req.isSeasional());
        food.setVegetarian(req.isVegetrian());

        Food savedFood = foodRepository.save(food);
        restaurant.getFood().add(savedFood);
        return savedFood;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
        Food food = findFoodById(foodId);
        food.setRestaurant(null);
        foodRepository.save(food);
    }

    @Override
    public List<Food> getRestaurantsFood(Long restaurantId, boolean isVegiterian, boolean isNonveg, boolean isSeasonal, String foodCategory) {
        return List.of();
    }

    @Override
    public List<Food> searchFood(String keyWord) {
        return List.of();
    }

    @Override
    public Food findFoodById(Long id) {
        return null;
    }

    @Override
    public Food updateAvaliabilityStatus(long id) throws Exception {
        return null;
    }
}
