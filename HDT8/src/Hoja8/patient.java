package Hoja8;

public class patient implements Comparable<patient>{
    private String name;
    private String symptom;
    private String code;

    public patient(String name, String symptom, String code){
        this.name= name;
        this.symptom = symptom;
        this.code = code;
    }

    public String getName(){
        return name;
    }
    public String getSymptom(){
        return symptom;
    }
    public String getCode(){
        return code;
    }

    @Override
    public int compareTo(patient paciente) {
        return code.compareTo(paciente.getCode());
    }
}