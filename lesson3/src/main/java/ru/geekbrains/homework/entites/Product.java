package ru.geekbrains.homework.entites;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private int id;
    private String title;
    private double cost;
}
