package ru.geekbrains.homework;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("plan")
@Scope("prototype")
public class ClinicPlan implements Plan {

    @Override
    public void doShow() {
        System.out.println("Тут был план клиники");
    }
}
