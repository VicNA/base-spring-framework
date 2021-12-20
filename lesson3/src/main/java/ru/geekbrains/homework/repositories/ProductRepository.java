package ru.geekbrains.homework.repositories;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.geekbrains.homework.entites.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class ProductRepository {

    private List<Product> productList = new ArrayList<>();

    public Product findOneById(int id) {
        return productList.stream()
                .filter(product -> product.getId()==id)
                .findAny().get();
    }
}
