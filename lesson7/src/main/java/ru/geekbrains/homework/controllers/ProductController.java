package ru.geekbrains.homework.controllers;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String showPage(Model model, @RequestParam(defaultValue = "1") Integer page) {
        if (page < 1) page = 1;

        Page<Product> products = productService.findAll(page);
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping(path = "/remove/{id}", method = RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long productId) {
        productService.removeById(productId);
        return "redirect:/products/list";
    }
}
