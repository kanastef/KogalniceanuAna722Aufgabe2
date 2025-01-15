package View;

import Controller.Controller;
import Model.Medicine;
import Model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private final Controller controller;

    public ConsoleApp(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Medicine");
            System.out.println("3. Filter Patients by Diagnosis");
            System.out.println("4. Filter Patients by Purchased Product Sickness");
            System.out.println("5. Sort Patient Medicine");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1-> managePatients();
                case 2-> manageMedicine();
                case 3-> filterByDiagnosis();
                case 4-> filterBySickness();
                case 5-> sortPatientMedicine();
                case 0-> System.exit(0);
                default -> running = false;
            }
        }
    }

    public void managePatients() {
        boolean running = true;
        while (running) {
            System.out.println("1. Create Patient");
            System.out.println("2. Read Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Get Patients");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1->{
                    System.out.println("Enter Patient name: ");
                    String name = scanner.next();
                    System.out.println("Enter Patient age: ");
                    int age = scanner.nextInt();
                    System.out.println("Enter Patient diagnosis: ");
                    String diagnosis = scanner.next();
                    int id = controller.createPatient(name, age, diagnosis);
                    System.out.println("Patient with the id " + id + " was created.");
                }
                case 2->{
                    System.out.println("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    System.out.println(controller.readPatient(id));
                }
                case 3->{
                    System.out.println("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter Patient name: ");
                    String name = scanner.next();
                    System.out.println("Enter Patient age: ");
                    int age = scanner.nextInt();
                    System.out.println("Enter Patient diagnosis: ");
                    String diagnosis = scanner.next();
                    boolean success = controller.updatePatient(id, name, age, diagnosis);
                    if (success) {
                        System.out.println("Patient with the id " + id + " was successfully updated.");
                    } else {
                        System.out.println("Patient with the id " + id + " was not updated.");
                    }
                }
                case 4->{
                    System.out.println("Enter Patient id: ");
                    int id = scanner.nextInt();
                    boolean success = controller.deletePatient(id);
                    if (success) {
                        System.out.println("Patient with the id " + id + " was successfully deleted.");
                    } else {
                        System.out.println("Patient with the id " + id + " was not deleted.");
                    }
                }
                case 5->{
                    controller.readAllPatients().forEach(System.out::println);
                }
                case 0->{
                    running = false;
                }
                default -> {
                    System.out.println("Invalid choice. Try again.");
                    running = false;
                }
            }
        }
    }

    public void manageMedicine() {
        boolean running = true;
        while (running) {
            System.out.println("1. Create Medicine");
            System.out.println("2. Read Medicine");
            System.out.println("3. Update Medicine");
            System.out.println("4. Delete Medicine");
            System.out.println("5. Get Medicines");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1->{
                    System.out.println("Enter Medicine name: ");
                    String name = scanner.next();
                    System.out.println("Enter Medicine price: ");
                    double price = scanner.nextDouble();
                    System.out.println("Enter Medicine sickness: ");
                    String sickness = scanner.next();
                    int id = controller.createMedicine(name, price, sickness);
                    System.out.println("Medicine with the id " + id + " was created.");
                }
                case 2->{
                    System.out.println("Enter Medicine id: ");
                    int id = scanner.nextInt();
                    System.out.println(controller.readMedicine(id));
                }
                case 3->{
                    System.out.println("Enter Product id: ");
                    int id = scanner.nextInt();
                    System.out.println("Enter Medicine name: ");
                    String name = scanner.next();
                    System.out.println("Enter Medicine price: ");
                    double price = scanner.nextDouble();
                    System.out.println("Enter Medicine sickness: ");
                    String sickness = scanner.next();
                    boolean success = controller.updateMedicine(id, name, price, sickness);
                    if (success) {
                        System.out.println("Medicine with the id " + id + " was successfully updated.");
                    } else {
                        System.out.println("Medicine with the id " + id + " was not updated.");
                    }
                }
                case 4->{
                    System.out.println("Enter Medicine id: ");
                    int id = scanner.nextInt();
                    boolean success = controller.deleteMedicine(id);
                    if (success) {
                        System.out.println("Medicine with the id " + id + " was successfully deleted.");
                    } else {
                        System.out.println("Medicine with the id " + id + " was not deleted.");
                    }
                }
                case 5->{
                    controller.readAllMedicines().forEach(System.out::println);
                }
                case 0->{
                    running = false;
                }
                default -> {
                    System.out.println("Invalid choice. Try again.");
                    running = false;
                }
            }
        }
    }

    public void filterByDiagnosis() {
        System.out.println("Enter diagnosis to filter by: ");
        Scanner scanner = new Scanner(System.in);
        String diagnosis = scanner.next();
        List<Patient> patients = controller.filterByDiagnosis(diagnosis);
        patients.forEach(System.out::println);
    }

    public void filterBySickness() {
        System.out.println("Enter sickness to filter by: ");
        Scanner scanner = new Scanner(System.in);
        String sickness = scanner.next();
        List<Patient> patients = controller.filterBySickness(sickness);
        patients.forEach(System.out::println);
    }

    public void sortPatientMedicine() {
        System.out.println("Enter Patient id: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Choose order to sort medicine by: ");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int choice = scanner.nextInt();
        List<Medicine> meds = new ArrayList<>();
        switch (choice) {
            case 1-> {
                meds = controller.sortPatientMedicine(1, id);
                meds.forEach(System.out::println);
            }
            case 2-> {
                meds = controller.sortPatientMedicine(0, id);
                meds.forEach(System.out::println);
            }
            default -> System.out.println("Invalid choice. Try again.");
        }
    }

}
