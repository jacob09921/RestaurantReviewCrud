package com.example.restaurantReview.Controllers;

import com.example.restaurantReview.Entities.Restaurant;
import com.example.restaurantReview.Entities.Review;
import com.example.restaurantReview.Exception.ApiRequestException;
import com.example.restaurantReview.Repositories.RestaurantRepository;
import com.example.restaurantReview.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

     @Autowired
     private RestaurantRepository restaurantRepository;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/restaurants/{restaurantName}/reviews")
    public Iterable getAllReviews(@PathVariable String restaurantName){
        return reviewService.getAllReviews(restaurantName);
    }

    @GetMapping("/restaurants/{restaurantName}/reviews/{id}")
    public Review getReview(@PathVariable String restaurantName, @PathVariable Long id){
        return reviewService.getReview(id, restaurantName);
    }

    @PostMapping("/restaurants/{restaurantName}/reviews")
    public String addReview(@RequestBody Review review, @PathVariable String restaurantName){
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        if (restaurant == null){
            throw new ApiRequestException("Restaurant did not exist");
        }
        review.setRestaurant(restaurant);
        reviewService.addReview(review);
        return "ADDED";
    }

    @PutMapping("/restaurants/{restaurantName}/reviews/{id}")
    public String updateReview(@PathVariable String restaurantName, @PathVariable Long id, @RequestBody Review review){;
        Restaurant restaurant = restaurantRepository.findByName(restaurantName);
        if (restaurant == null){
            throw new ApiRequestException("Restaurant did not exist");
        }
        review.setRestaurant(restaurant);
        reviewService.updateReview(review, id);
        return "Updated";
    }

    @DeleteMapping("/restaurants/{restaurantName}/reviews/{id}")
    public String deleteReview(@PathVariable String restaurantName, @PathVariable Long id){
        reviewService.deleteReview(id, restaurantName);
        return "Deleted";
    }

}
