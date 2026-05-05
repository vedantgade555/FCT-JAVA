package com.vedant.request;

import com.vedant.model.Category;
import com.vedant.model.IngridientsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;
    private Category category;
    private List<String> images;

    private Long restaurantId;
    private boolean Vegetrian;
    private boolean seasional;
    private List<IngridientsItem> ingridients;


}
