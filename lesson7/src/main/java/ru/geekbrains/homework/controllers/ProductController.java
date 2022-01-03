package ru.geekbrains.homework.controllers;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.homework.entities.Product;
import ru.geekbrains.homework.service.ProductService;

import java.util.List;

@Setter
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showPage(Model model) {
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }
}
