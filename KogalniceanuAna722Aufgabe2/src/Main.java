import Controller.Controller;
import Model.Medicine;
import Model.Patient;
import Repository.Repository;
import View.ConsoleApp;

public class Main {
    public static void main(String[] args) {
        Repository<Patient> patientRepository = new Repository<Patient>();
        Repository<Medicine> medicineRepository = new Repository<Medicine>();
        Controller controller = new Controller(medicineRepository, patientRepository);
        ConsoleApp app = new ConsoleApp(controller);

        Medicine medicine1 = new Medicine("Medicine 1", 30.00, "Sickness1");
        Medicine medicine2 = new Medicine("Medicine 2", 10.00, "Sickness2");
        Medicine medicine3 = new Medicine("Medicine 3", 15.00, "Sickness3");

        medicineRepository.create(medicine1);
        medicineRepository.create(medicine2);
        medicineRepository.create(medicine3);

        Patient patient1 = new Patient(1, "Name1", 20, "Diagnosis1");
        Patient patient2 = new Patient(2, "Name2", 30, "Diagnosis1");
        Patient patient3 = new Patient(3, "Name3", 25, "Diagnosis3");
        Patient patient4 = new Patient(4, "Name4", 10, "Diagnosis4");

        patient1.addMeds(medicine1);
        patient1.addMeds(medicine2);
        patient2.addMeds(medicine3);
        patient4.addMeds(medicine1);
        patient3.addMeds(medicine2);
        patient4.addMeds(medicine3);

        patientRepository.create(patient1);
        patientRepository.create(patient2);
        patientRepository.create(patient3);
        patientRepository.create(patient4);

        app.run();
    }
}