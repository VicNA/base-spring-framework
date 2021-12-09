package ru.geekbrains.lesson1.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Human {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MedicalInstitution clinic = context.getBean("clinic", MedicalInstitution.class);
        clinic.visitDoctor();
    }
}
