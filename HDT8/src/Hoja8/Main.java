package Hoja8;


import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;


public class Main {
	private static String readHospital(String patientFile) throws FileNotFoundException {
        BufferedReader hospitalScan = new BufferedReader(new FileReader(patientFile));
        StringBuilder patients = new StringBuilder();
        
        try {
            String attendTo = hospitalScan.readLine();
            while (attendTo != null) {
                patients.append(attendTo).append("\n");
                attendTo = hospitalScan.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return patients.toString();
    }

    public static void main(String[] args) {
        String patientFile = "pacientes.txt";
        PriorityQueue<patient> patientQueue = new PriorityQueue<patient>();


        try {
            String patientsData = readHospital(patientFile);
            String[] patients = patientsData.split("\n");

            for (String patient : patients) {
                String[] patientDetails = patient.split(",");
                String name = patientDetails[0];
                String symptom = patientDetails[1];
                String code = patientDetails[2];
                patient p = new patient(name, symptom, code);
                patientQueue.add(p);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (!patientQueue.isEmpty()) {
            patient p = patientQueue.poll();
            System.out.println("Atendiendo a " + p.getName() + " con código " + p.getCode());
        }
    }
}
