package ru.geekbrains.homework.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework.entities.Product;
import ru.geekbrains.homework.repositories.ProductRepository;

import java.util.List;

@Setter
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
