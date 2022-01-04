package ru.geekbrains.homework.controllers;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.geekbrains.homework.entities.Product;
import ru.geekbrains.homework.service.ProductService;

import java.util.List;

@Setter
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/list")
    public String showPage(Model model) {
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long productId) {
        productService.removeById(productId);
        return "redirect:/products/list";
    }
}
