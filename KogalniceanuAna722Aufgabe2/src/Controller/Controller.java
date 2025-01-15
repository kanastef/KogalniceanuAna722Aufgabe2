package Controller;

import Model.Medicine;
import Repository.Repository;
import Model.Patient;

import java.util.List;
import java.util.Optional;

public class Controller {
    Repository<Medicine> medicineRepository;
    Repository<Patient> patientsRepository;

    public Controller(Repository<Medicine> medicineRepository, Repository<Patient> patientsRepository) {
        this.medicineRepository = medicineRepository;
        this.patientsRepository = patientsRepository;
    }

    public int createPatient(String name, int age, String diagnosis) {
        return patientsRepository.create(new Patient(0, name, age, diagnosis));
    }

    public int createMedicine(String name, double price, String sickness) {
        return medicineRepository.create(new Medicine(name, price, sickness));
    }

    public Optional<Patient> readClient(int id) {
        return patientsRepository.read(id);
    }

    public Optional<Medicine> readProduct(int id) {
        return medicineRepository.read(id);
    }

    public boolean updatePatient(int id, String name, int age, String diagnosis) {
        Optional<Patient> oldClient = patientsRepository.read(id);
        if (oldClient.isPresent()) {
            Patient newPatient = new Patient(id, name, age, diagnosis);
            newPatient.setMeds(oldClient.get().getMeds());
            return patientsRepository.update(id, newPatient);
        }
        return false;
    }

    public boolean updateProduct(int id, String name, double price, String sickness) {
        return medicineRepository.update(id, new Medicine(name, price, sickness));
    }

    public boolean deleteClient(int id) {
        return patientsRepository.delete(id);
    }

    public boolean deleteProduct(int id) {
        return medicineRepository.delete(id);
    }

    public List<Patient> readAllClients() {
        return patientsRepository.readAll();
    }

    public List<Medicine> readAllProducts() {
        return medicineRepository.readAll();
    }
}
