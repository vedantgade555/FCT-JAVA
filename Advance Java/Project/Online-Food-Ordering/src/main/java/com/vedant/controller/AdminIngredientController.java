package com.vedant.controller;

import com.vedant.Service.IngredientsService;
import com.vedant.model.IngridientsCategory;
import com.vedant.model.IngridientsItem;
import com.vedant.request.IngredientCategoryRequest;
import com.vedant.request.IngredientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
public class AdminIngredientController {

    @Autowired
    private IngredientsService ingredientsService;

    @PostMapping("/category")
    public ResponseEntity<IngridientsCategory> createIngredientCategory(
            @RequestBody IngredientCategoryRequest req) throws Exception {
        IngridientsCategory item = ingredientsService.createIngredientCategory(req.getName(), req.getRestaurantId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<IngridientsItem> createIngredientItem(
            @RequestBody IngredientRequest req) throws Exception {
        IngridientsItem item = ingredientsService.createIngredientItem(req.getRestaurantId(), req.getName(), req.getCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<IngridientsItem> updateIngredientStock(
            @PathVariable Long id) throws Exception {
        IngridientsItem item = ingredientsService.updateStock(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngridientsItem>> getRestaurantIngredient(
            @PathVariable Long id) throws Exception {
        List<IngridientsItem> items = ingredientsService.findRestaurantsIngredients(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngridientsCategory>> getRestaurantIngredientCategory(
            @PathVariable Long id) throws Exception {
        List<IngridientsCategory> items = ingredientsService.findIngredientCategoryByRestaurantId(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
