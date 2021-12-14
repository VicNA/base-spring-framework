package ru.geekbrains.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Product {
    private int id;
    private String title;
    private double cost;
}
