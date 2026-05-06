package com.vedant.Service;

import com.vedant.model.IngridientsCategory;
import com.vedant.model.IngridientsItem;

import java.util.List;

public interface IngredientsService {

    public IngridientsCategory createIngredientCategory(String name, Long restaurantId) throws Exception;

    public IngridientsCategory findIngredientCategoryById(Long id) throws Exception;

    public List<IngridientsCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;

    public IngridientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception;

    public List<IngridientsItem> findRestaurantsIngredients(Long restaurantId);

    public IngridientsItem updateStock(Long id) throws Exception;
}
