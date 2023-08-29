package com.example.restaurantReview.Services;


import com.example.restaurantReview.Entities.Review;
import com.example.restaurantReview.Exception.ApiRequestException;
import com.example.restaurantReview.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Iterable getAllReviews(String name){
        return reviewRepository.findAll().stream().filter(it -> it.getRestaurant().getName().equals(name)).toList();
    }

    public Review getReview(Long id, String restaurantName){
        Review review = reviewRepository.findById(id).orElse(null);
        if (review != null && review.getRestaurant().getName().equals(restaurantName)){
            return review;
        }
        else {
            throw new ApiRequestException("Review does not exist");
        }

    }

    public void addReview(Review review){
        if (review != null){
            reviewRepository.save(review);
        } else {
            throw new ApiRequestException("invalid review body");
        }

    }

    public void updateReview(Review review, Long id){
        Review review1 = reviewRepository.findById(id).orElse(null);
        if (review1 != null){
            review1.setComments(review.getComments());
            review1.setRating(review.getRating());
            reviewRepository.save(review1);
        } else {
            throw new ApiRequestException("Review does not exist to update");

        }
    }


    public void deleteReview(Long id, String restaurantId){
        Review review = reviewRepository.findById(id).orElse(null);
        if(review != null && review.getRestaurant().getName().equals(restaurantId)){
            reviewRepository.deleteById(id);
        } else {
            throw new ApiRequestException("Review does not exist to delete");
        }
    }
}
