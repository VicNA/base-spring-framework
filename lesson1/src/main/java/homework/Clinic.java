package homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("clinic")
@Scope("prototype")
public class Clinic implements MedicalInstitution {

    private MedicalCard card;
    private Schedule schedule;
    private Plan plan;

    @Autowired
//    @Qualifier("PatientMedicalCard")  // Почему при указании этой и дургих ниже аннотации, валится в ошибку?
    public void setMedicalCard(MedicalCard card) {
        this.card = card;
    }

    @Autowired
//    @Qualifier("DoctorShedule")
    public void setDoctorShedule(Schedule schedule) {
        this.schedule = schedule;
    }
    @Autowired
//    @Qualifier("ClinicPlan")
    public void setClinicPlan(Plan plan) {
        this.plan = plan;
    }

    @Override
    public void visitDoctor() {
        card.doShow();
        schedule.doShow();
        plan.doShow();

        System.out.println("Отправили в кабинет врача");
    }
}
