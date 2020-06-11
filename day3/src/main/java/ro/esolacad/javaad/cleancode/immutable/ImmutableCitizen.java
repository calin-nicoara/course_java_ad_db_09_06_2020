package ro.esolacad.javaad.cleancode.immutable;

import java.time.LocalDate;
import java.util.Objects;

import ro.esolacad.javaad.csv.Citizen;

public class ImmutableCitizen {
    private final Long idNumber;
    private final String name;
    private final LocalDate dateOfBirth;
    private final String nationality;
    private final boolean isForeigner;
//    private final ImmutableCitizenComponent immutableCitizenComponent;

    public ImmutableCitizen(final Long idNumber,  String name,
                            final LocalDate dateOfBirth, final String nationality,
                            final boolean isForeigner) {
        this.idNumber = idNumber;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.isForeigner = isForeigner;
        this.name = name;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public boolean getIsForeigner() {
        return isForeigner;
    }

    public String getName() {
        return name;
    }

    public ImmutableCitizen setName(String newName) {
        return new ImmutableCitizen(this.idNumber, newName, this.dateOfBirth,
                this.nationality, this.isForeigner);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ImmutableCitizen citizen = (ImmutableCitizen) o;
        return isForeigner == citizen.isForeigner &&
                Objects.equals(idNumber, citizen.idNumber) &&
                Objects.equals(dateOfBirth, citizen.dateOfBirth) &&
                Objects.equals(nationality, citizen.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, dateOfBirth, nationality, isForeigner);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "idNumber=" + idNumber +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nationality='" + nationality + '\'' +
                ", isForeigner=" + isForeigner +
                '}';
    }

}
