package Hoja8;

import java.util.Comparator;

public class patientComparator implements Comparator<patient> {
    public int compare(patient p1, patient p2) {
        int result = p1.getCode().compareTo(p2.getCode());
        if (result == 0) {
            return 1;
        } else {
            return result;
        }
    }
}

