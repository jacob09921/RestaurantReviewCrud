package com.example.restaurantReview.Controllers;


import com.example.restaurantReview.Entities.Restaurant;
import com.example.restaurantReview.Exception.ApiRequestException;
import com.example.restaurantReview.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public Iterable getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/restaurants/{name}")
    public Restaurant getRestaurant(@PathVariable String name){
        return restaurantService.getRestaurant(name);
    }

    @PostMapping("/restaurants")
    public String addRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.addRestaurant(restaurant);
        return "ADDED";
    }

    @PutMapping("/restaurants/{name}")
    public String updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable String name){
        restaurantService.updateRestaurant(restaurant, name);
        return "UPDATED";
    }

    @DeleteMapping("/restaurants/{name}")
    public String deleteRestaurants(@PathVariable String name){
        restaurantService.deleteRestaurant(name);
        return "Deleted";
    }


}
