package com.thompson.thompsonPack.dto;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data

@FieldDefaults(level = AccessLevel.PRIVATE)
public class CatDTO {
    private String name; // без @FieldDefaults
    int age;
    int weight;
}
