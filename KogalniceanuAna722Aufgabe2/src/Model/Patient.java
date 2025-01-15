package Model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    int id;
    String name;
    int age;
    String diagnosis;
    List<Medicine> meds;

    public Patient(int id, String name, int age, String diagnosis) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.meds = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<Medicine> getMeds() {
        return meds;
    }

    public void setMeds(List<Medicine> meds) {
        this.meds = meds;
    }

    public void addMeds(Medicine med) {
        this.meds.add(med);
    }

    public void removeMeds(Medicine med) {
        this.meds.remove(med);
    }
}
