package com.example.mod7.data.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BookRatingDTO {

    private Integer rating;
    private Integer countSum;
    private Map<Integer, Integer> usersCountByRating = new HashMap<>();

}
