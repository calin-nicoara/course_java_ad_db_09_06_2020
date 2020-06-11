package ro.esolacad.javaad.csv;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CitizenCsvTest {

    @Test
    public void testReadCitizenFromCsv() throws Exception {
        CitizenCsvProcessor citizenCsvProcessor = new CitizenCsvProcessor("citizen_read.csv");

        List<Citizen> allCitizens = citizenCsvProcessor.findAllCitizens();

        assert allCitizens.size() == 2;
        Citizen citizen1 = new Citizen(1L, "Ion Popescu",
                LocalDate.of(1993, 2, 1), "Romanian",
                false);

        assert allCitizens.get(0).equals(citizen1);

        System.out.println(allCitizens);
    }

    @Test
    public void testWriteCitizenToCsv() {
        CitizenCsvProcessor citizenCsvProcessor = new CitizenCsvProcessor("citizen_write.csv");

        Citizen citizen1 = new Citizen(4L, "Mary Smith",
                LocalDate.of(1980, 2, 1), "USA",
                true);
        try {

        }catch (RuntimeException e) {
            citizenCsvProcessor.saveCitizen(Collections.singletonList(citizen1));
        }

    }

    @Test
    public void testWriteCitizenToCsvWithReflection() throws Exception {
        CitizenCsvProcessor citizenCsvProcessor = new CitizenCsvProcessor("citizen_write.csv");

        Citizen citizen1 = new Citizen(5L, "Josh Smith With Methods",
                LocalDate.of(1980, 2, 1), "USA",
                true);

        citizenCsvProcessor.saveCitizenWithReflection(Collections.singletonList(citizen1));
    }
}
