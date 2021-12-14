package ru.geekbrains.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductList", urlPatterns = "/product_list")
public class ProductList extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ProductList.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Method doGet");

        List<Product> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(new Product(i, "Product" + i, i));
        }

        req.setAttribute("products", list);

//        System.out.println(list);

        RequestDispatcher dispatcher = req.getRequestDispatcher("view/product_list.jsp");
        dispatcher.forward(req, resp);
    }
}
