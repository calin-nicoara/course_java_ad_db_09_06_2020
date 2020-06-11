package ro.esolacad.javaad.cleancode;

import ro.esolacad.javaad.csv.Citizen;

public class TEstNullReferences {

    public static void process() {
        Citizen citizen = null;

        if(citizen != null) {
            useCitizen(citizen);
        }
    }

    public static void useCitizen(Citizen citizen) {
        System.out.println(citizen.getIdNumber());
    }
}
