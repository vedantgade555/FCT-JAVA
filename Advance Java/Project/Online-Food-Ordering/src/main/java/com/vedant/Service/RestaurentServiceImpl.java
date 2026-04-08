package com.vedant.Service;

// Import required classes
import com.vedant.dto.RestaurantDto;
import com.vedant.model.Address;
import com.vedant.model.Restaurant;
import com.vedant.model.User;
import com.vedant.repository.AddressRepository;
import com.vedant.repository.RestaurentRepository;
import com.vedant.repository.UserRepository;
import com.vedant.request.CreateRestaurentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service // Marks this class as Service Layer (Business Logic)
public class RestaurentServiceImpl implements RestaurentService {

    @Autowired
    private RestaurentRepository restaurentRepository;
    // Used to perform CRUD operations on Restaurant

    @Autowired
    private AddressRepository addressRepository;
    // Used to save and fetch Address entity

    @Autowired
    private UserService userService;
    // Used for user-related operations (not used here currently)

    @Autowired
    private UserRepository userRepository;
    // Used to update user (favorites etc.)

    @Override
    public Restaurant createRestaurant(CreateRestaurentRequest req, User user) {

        // Save address first (because Restaurant has relation with Address)
        Address address = addressRepository.save(req.getAddress());

        // Create new Restaurant object
        Restaurant restaurant = new Restaurant();

        // Set all fields from request
        restaurant.setAddress(address);
        restaurant.setContactInformation(req.getContactInformation());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setDescription(req.getDescription());
        restaurant.setImages(req.getImages());
        restaurant.setName(req.getName());
        restaurant.setOpeningHours(req.getOpeningHours());

        // Set current date-time as registration date
        restaurant.setRegistrationDate(LocalDateTime.now());

        // Set owner of restaurant
        restaurant.setOwner(user);

        // Save restaurant into DB
        return restaurentRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurentId, CreateRestaurentRequest updateRestaurent) throws Exception {

        // Fetch restaurant by ID
        Restaurant restaurant = findRestaurantById(restaurentId);

        // Update fields only if they are not null

        if(restaurant.getCuisineType() != null){
            restaurant.setCuisineType(updateRestaurent.getCuisineType());
        }

        if(restaurant.getDescription() != null){
            restaurant.setDescription(updateRestaurent.getDescription());
        }

        if(restaurant.getName() != null){
            restaurant.setName(updateRestaurent.getName());
        }

        // Save updated restaurant
        return restaurentRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurentId) throws Exception {

        // Fetch restaurant
        Restaurant restaurant = findRestaurantById(restaurentId);

        // Check if exists
        if(restaurant == null){
            throw new Exception("Restaurant not found");
        }

        // Delete from DB
        restaurentRepository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() throws Exception {

        // Fetch all restaurants from DB
        return restaurentRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {

        // Search using custom query (name or cuisine)
        return restaurentRepository.findSearchQuery(keyword);
    }

    @Override
    public Restaurant findRestaurantById(Long restaurentId) throws Exception {

        // Find restaurant using Optional
        Optional<Restaurant> opt = restaurentRepository.findById(restaurentId);

        // If not found, throw exception
        if(opt.isEmpty()){
            throw new Exception("Restaurant not found with given id " + restaurentId);
        }

        // Return restaurant
        return opt.get();
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {

        // Find restaurant by owner ID
        Restaurant restaurant = restaurentRepository.findByOwnerId(userId);

        // If not found, throw exception
        if(restaurant == null){
            throw new Exception("Restaurant not found with owner id " + userId);
        }

        return restaurant;
    }

    @Override
    public RestaurantDto addToFavorites(Long restaurentId, User user) throws Exception {

        // Fetch restaurant
        Restaurant restaurant = findRestaurantById(restaurentId);

        // Convert Restaurant → DTO (lightweight object)
        RestaurantDto dto = new RestaurantDto();
        dto.setDescription(restaurant.getDescription());
        dto.setImages(restaurant.getImages());
        dto.setTitle(restaurant.getName());
        dto.setId(restaurentId);

        // Toggle favorite (add/remove)
        if(user.getFavorites().contains(dto)){
            user.getFavorites().remove(dto);
        } else {
            user.getFavorites().add(dto);
        }

        // Save updated user
        userRepository.save(user);

        return dto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {

        // Fetch restaurant
        Restaurant restaurant = findRestaurantById(id);

        // Toggle open/close status
        restaurant.setOpen(!restaurant.isOpen());

        // Save updated status
        return restaurentRepository.save(restaurant);
    }
}