package com.vedant.Service;

import com.vedant.model.Category;
import com.vedant.model.Food;
import com.vedant.model.Restaurant;
import com.vedant.repository.FoodRepository;
import com.vedant.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<Food> foods = foodRepository.findByRestaurantId(restaurantId);

        if(isVegiterian)
        {
            foods = filterByVegiterian(foods,isVegiterian);
        }
        if(isNonveg)
        {
            foods = filterByNonveg(foods,isNonveg);
        }
        if(isSeasonal)
        {
            foods = filterByIsSeasonal(foods,isSeasonal);
        }
        if(foodCategory!=null && !foodCategory.equals(""))
        {
            foods = filterByCategory(foods,foodCategory);

        }        return List.of();
    }

    private List<Food> filterByVegiterian(List<Food> foods, boolean isVegiterian)
    {
        return foods.stream().filter(food -> food.isVegetarian()==isVegiterian).collect(Collectors.toList());
    }

    private List<Food> filterByNonveg(List<Food> foods, boolean isNonveg)
    {
        return foods.stream().filter(food->food.isVegetarian()==false).collect(Collectors.toList());
    }

    private List<Food> filterByIsSeasonal(List<Food> foods, boolean isSeasonal)
    {
        return foods.stream().filter(food->food.isSessonal()==isSeasonal).collect(Collectors.toList());
    }

    private List<Food> filterByCategory(List<Food> foods, String categoryName) {
        return foods.stream()
                .filter(food -> {
                    if (food.getFoodCategory() != null) {
                        return food.getFoodCategory().getName().equals(categoryName);
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Food> searchFood(String keyWord) {
        return foodRepository.searchFood(keyWord);
    }

    @Override
    public Food findFoodById(Long id) {
        Optional<Food> food = foodRepository.findById(id);

        if (food.isEmpty()) {
            throw new RuntimeException("Food does not exist with id: " + id);
        }
        return food.get();
    }

    @Override
    public Food updateAvaliabilityStatus(long id) throws Exception {
        Food food = findFoodById(id);
        food.setAvailable(!food.isAvailable());
        return foodRepository.save(food);
    }
}
