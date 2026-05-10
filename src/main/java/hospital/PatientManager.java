package hospital;

import java.util.*;
import java.util.stream.Collectors;

public class PatientManager {

    // ArrayList as the data structure
    private List<Patient> patients = new ArrayList<>();

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    // Sort by age
    public List<Patient> sortByAge() {
        return patients.stream()
                .sorted(PatientComparators.byAge())
                .collect(Collectors.toList());
    }

    // Sort by name
    public List<Patient> sortByName() {
        return patients.stream()
                .sorted(PatientComparators.byName())
                .collect(Collectors.toList());
    }

    // Patients above age 60
    public List<Patient> patientsAbove60() {
        return patients.stream()
                .filter(p -> p.getAge() > 60)
                .collect(Collectors.toList());
    }
}