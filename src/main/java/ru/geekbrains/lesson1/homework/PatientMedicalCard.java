package ru.geekbrains.lesson1.homework;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("medicalCard")
@Scope("prototype")
public class PatientMedicalCard implements MedicalCard {

    private int numberCard;

    public PatientMedicalCard() {
        Random random = new Random();
        numberCard = random.nextInt();
    }

    @Override
    public void doShow() {
        System.out.printf("Номер карточки пациента: %s\n", numberCard);
    }
}
