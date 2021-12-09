package ru.geekbrains.lesson1.homework;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("schedule")
@Scope("prototype")
public class DoctorSchedule implements Schedule {

    @Override
    public void doShow() {
        System.out.println("Расписание приема врача: с 9:00 до 15:00");
    }
}
