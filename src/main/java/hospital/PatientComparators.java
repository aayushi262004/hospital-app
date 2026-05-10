package hospital;

import java.util.Comparator;

public class PatientComparators {

    // Sort by age (ascending)
    public static Comparator<Patient> byAge() {
        return Comparator.comparingInt(Patient::getAge);
    }

    // Sort by name (alphabetical)
    public static Comparator<Patient> byName() {
        return Comparator.comparing(Patient::getName);
    }
}