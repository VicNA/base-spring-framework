package ru.geekbrains.homework.services;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework.enitites.Product;
import ru.geekbrains.homework.repositories.ProductRepository;

import java.util.List;

@Setter
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id) {
        return productRepository.findOneById(id);
    }

    public void addProduct(Product... products) {
        for (Product product : products) {
            productRepository.getProductList().add(product);
        }
    }

    public List<Product> getProducts() {
        return productRepository.getProductList();
    }
}
