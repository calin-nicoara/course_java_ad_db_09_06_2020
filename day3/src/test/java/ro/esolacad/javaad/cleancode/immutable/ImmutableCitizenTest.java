package ro.esolacad.javaad.cleancode.immutable;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableCitizenTest {

    @Test
    public void testImmutable() {
        final ImmutableCitizen immutableCitizenVariable = new ImmutableCitizen(
                1L, "bobo", LocalDate.now(), "Romanian", false
        );

//        modifyCitizen(immutableCitizenVariable);
//        assert immutableCitizenVariable.getIdNumber() == 4L;

        ImmutableCitizen immutableCitizen = immutableCitizenVariable.setName("newName");

        System.out.println(immutableCitizenVariable);
        System.out.println(immutableCitizen);
    }

    public void modifyCitizen(ImmutableCitizen citizen) {
    }

    @Test
    public void testLocalDAtE() {
        LocalDate now = LocalDate.now();

        LocalDate localDate = now.plusMonths(2);
    }

}
