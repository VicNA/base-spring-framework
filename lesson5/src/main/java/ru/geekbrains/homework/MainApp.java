package ru.geekbrains.homework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(ShopCart.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

//        Session session = factory.getCurrentSession();
//        session.beginTransaction();

    }
}
