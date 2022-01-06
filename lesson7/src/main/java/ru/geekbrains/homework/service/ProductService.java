package ru.geekbrains.homework.service;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<Product> findAll(Integer page) {
        return productRepository.findAll(PageRequest.of(page - 1, 10));
    }

    public void removeById(Long id) {
        productRepository.deleteById(id);
    }
}
