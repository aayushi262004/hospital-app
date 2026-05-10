package hospital;

public class Main {
    public static void main(String[] args) {

        PatientManager manager = new PatientManager();

        manager.addPatient(new Patient(1, "Ravi Kumar",   72, "Diabetes"));
        manager.addPatient(new Patient(2, "Anjali Rao",   45, "Fever"));
        manager.addPatient(new Patient(3, "Mohan Das",    65, "Hypertension"));
        manager.addPatient(new Patient(4, "Priya Singh",  30, "Cold"));
        manager.addPatient(new Patient(5, "Arjun Sharma", 80, "Arthritis"));

        System.out.println("=== All Patients ===");
        manager.getAllPatients().forEach(System.out::println);

        System.out.println("\n=== Sorted by Age ===");
        manager.sortByAge().forEach(System.out::println);

        System.out.println("\n=== Sorted by Name ===");
        manager.sortByName().forEach(System.out::println);

        System.out.println("\n=== Patients Above 60 ===");
        manager.patientsAbove60().forEach(System.out::println);
    }
}