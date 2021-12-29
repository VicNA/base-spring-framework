package ru.geekbrains.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(ShopCart.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // TODO: 29.12.2021 Заполняем БД данными
        Session session = factory.getCurrentSession();

        User user1 = new User("User1");
        User user2 = new User("User2");
        ShopCart shopCart1 = new ShopCart(101, user1);
        ShopCart shopCart2 = new ShopCart(102, user2);
        Product product1 = new Product("Product1", 10);
        Product product2 = new Product("Product2", 20);
        Product product3 = new Product("Product3", 50);
        Product product4 = new Product("Product4", 40);
        Product product5 = new Product("Product5", 70);

        shopCart1.setProducts(Arrays.asList(product1, product2));
        shopCart2.setProducts(Arrays.asList(product3, product4, product5));

        session.beginTransaction();

        session.save(user1);
        session.save(user2);

        session.save(shopCart1);
        session.save(shopCart2);

        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);
        session.save(product5);

        session.getTransaction().commit();

        // TODO: 29.12.2021 Открываем новую сессию и вытаскиваем данные
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Product> allProducts = session.createQuery("from Product").getResultList();
        System.out.println(allProducts);
        session.getTransaction().commit();

        factory.close();
        session.close();

    }
}
