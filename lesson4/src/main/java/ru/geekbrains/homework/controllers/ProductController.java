package ru.geekbrains.homework.controllers;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.homework.enitites.Product;
import ru.geekbrains.homework.services.ProductService;

@Setter
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/showList")
    public String showListProduct(Model uiModel) {
        if (productService.getProducts().size() == 0) {
            int id;
            productService.addProduct(
                    new Product(id = 1, "Product" + id, id),
                    new Product(id = 5, "Product" + id, id),
                    new Product(id = 9, "Product" + id, id)
            );
        }

        uiModel.addAttribute("products", productService.getProducts());
        return "products";
    }

    @GetMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "product-form-result";
    }
}
