package com.example.restaurantReview.Repositories;

import com.example.restaurantReview.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
