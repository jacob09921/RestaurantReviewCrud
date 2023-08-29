package com.example.restaurantReview;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Restaurant Review Api",
				version = "1.0.0",
				description = "The project aims to give developers and consumers a free api",
				termsOfService = "https://github.com/jacob09921"
		)
)
public class RestaurantReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReviewApplication.class, args);
		System.out.println(multiTable(1));

	}

	public static String multiTable(int num) {
		String word = "";
		for (int i = 1; i <=10;i++){
			word = word + i + " * " + num + " = " + (i * num)+"\n";
		}
		return word;
	}





}
