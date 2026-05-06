package com.vedant.Service;

import com.vedant.model.IngridientsCategory;
import com.vedant.model.IngridientsItem;
import com.vedant.model.Restaurant;
import com.vedant.repository.IngredientCategoryRepository;
import com.vedant.repository.IngredientItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    @Autowired
    private IngredientItemRepository ingredientItemRepository;

    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Autowired
    private RestaurentService restaurantService;

    @Override
    public IngridientsCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);

        IngridientsCategory category = new IngridientsCategory();
        category.setRestaurant(restaurant);
        category.setName(name);

        return ingredientCategoryRepository.save(category);
    }

    @Override
    public IngridientsCategory findIngredientCategoryById(Long id) throws Exception {
        Optional<IngridientsCategory> opt = ingredientCategoryRepository.findById(id);

        if (opt.isEmpty()) {
            throw new Exception("Ingredient category not found");
        }
        return opt.get();
    }

    @Override
    public List<IngridientsCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
        restaurantService.findRestaurantById(id);
        return ingredientCategoryRepository.findByRestaurantId(id);
    }

    @Override
    public IngridientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
        IngridientsCategory category = findIngredientCategoryById(categoryId);

        IngridientsItem item = new IngridientsItem();
        item.setName(ingredientName);
        item.setRestaurant(restaurant);
        item.setCategory(category);

        IngridientsItem savedIngredient = ingredientItemRepository.save(item);
        category.getIngridientsItems().add(savedIngredient);

        return savedIngredient;
    }

    @Override
    public List<IngridientsItem> findRestaurantsIngredients(Long restaurantId) {
        return ingredientItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngridientsItem updateStock(Long id) throws Exception {
        Optional<IngridientsItem> optionalIngridientsItem = ingredientItemRepository.findById(id);

        if (optionalIngridientsItem.isEmpty()) {
            throw new Exception("Ingredient not found");
        }

        IngridientsItem item = optionalIngridientsItem.get();
        item.setInStock(!item.isInStock());
        return ingredientItemRepository.save(item);
    }
}
