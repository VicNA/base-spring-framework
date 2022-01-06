package ru.geekbrains.homework.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.homework.entities.Product;
import ru.geekbrains.homework.repositories.ProductRepository;

import java.util.List;

@Setter
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void removeById(Long id) {
        productRepository.deleteById(id);
    }
}
