package ro.esolacad.javaad.csv;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Citizen {
    /**
     * Long idNumber of Citizen
     */
    private Long idNumber;
    private String name;
    private LocalDate dateOfBirth;
    private String nationality;
    private boolean isForeigner;

    public Citizen() {}

    public Citizen(final Long idNumber,  String name,final LocalDate dateOfBirth, final String nationality,
                   final boolean isForeigner) {
        this.idNumber = idNumber;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.isForeigner = isForeigner;
        this.name = name;
    }

    /**
     * This is method for retieving id number
     * @return
     */
    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(final Long idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(final String nationality) {
        this.nationality = nationality;
    }

    public boolean getIsForeigner() {
        return isForeigner;
    }

    public void setForeigner(final boolean foreigner) {
        isForeigner = foreigner;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Citizen citizen = (Citizen) o;
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

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
