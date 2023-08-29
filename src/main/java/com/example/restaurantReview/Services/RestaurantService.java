package com.example.restaurantReview.Services;


import com.example.restaurantReview.Entities.Restaurant;
import com.example.restaurantReview.Exception.ApiRequestException;
import com.example.restaurantReview.Repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    //READ
    public Iterable getAllRestaurant(){
        return restaurantRepository.findAll();
    }
    //READ Specific
    public Restaurant getRestaurant(String name){
           Restaurant restaurant =  restaurantRepository.findByName(name);
           if (restaurant == null){
               throw new ApiRequestException("No restaurant existed");
           }
           return restaurant;
    }

    //ADD
    public void addRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }

    //UPDATE
    public void updateRestaurant(Restaurant restaurant, String name){
        Restaurant restaurant1 = restaurantRepository.findByName(name);
        if (restaurant1 == null){
            throw new ApiRequestException("No restaurant existed to update");
        }
        restaurant1.setName(restaurant.getName());
        restaurant1.setAddress(restaurant.getAddress());
        restaurantRepository.save(restaurant1);
    }

    //DELETE

    public void deleteRestaurant(String name){
        Restaurant restaurant = restaurantRepository.findByName(name);
        if (restaurant == null){
            throw new ApiRequestException("No restaurant existed to delete");
        }
         restaurantRepository.deleteById(restaurant.getId());
    }


}
