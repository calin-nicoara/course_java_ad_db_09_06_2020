package ro.esolacad.javaad.cleancode;

import java.time.LocalDate;

import ro.esolacad.javaad.csv.Citizen;

public class TestCleanCode {

    public void computenCitizenScore(Citizen citizen) {
        if(citizen.getIsForeigner()) {
            computeScoreForForeigner(citizen.getDateOfBirth());
        } else {
            computeScoreForDomestic(citizen.getDateOfBirth());
        }

//        computeScore(citizen.getDateOfBirth(), citizen.getIsForeigner());
    }

    private void computeScore(final LocalDate dateOfBirth, final boolean isForeigner) {
        if(isForeigner) {
            // COmpute for Foreigner
        } else {
            // Computer for Domestic
        }
    }

    private void computeScoreForDomestic(final LocalDate dateOfBirth) {

    }

    private void computeScoreForForeigner(final LocalDate dateOfBirth) {

    }
}
