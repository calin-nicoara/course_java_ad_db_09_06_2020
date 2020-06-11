package ro.esolacad.javaad.csv;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;


/**
 * @author Nicoara Calin
 *
 * 2020-11-06 Added read nad write processor
 * Ionut 2020-20-06 Added method order for reflection
 */
public class CitizenCsvProcessor {
    private String filePath;

    public CitizenCsvProcessor(final String filePath) {
        this.filePath = filePath;
    }

    public List<Citizen> findAllCitizens() throws IOException {
        return CSVReaderWriter.read(filePath, getCitizenFromArraysOfStrings());
    }

    private Function<String[], Citizen> getCitizenFromArraysOfStrings() {
        return rowFields -> {
            Citizen citizen =new Citizen();
            citizen.setIdNumber(Long.parseLong(rowFields[0]));
            citizen.setName(rowFields[1]);
            citizen.setDateOfBirth(LocalDate.parse(rowFields[2]));
            citizen.setNationality(rowFields[3]);
            citizen.setForeigner(Boolean.parseBoolean(rowFields[4]));

            return citizen;
        };
    }

    public void saveCitizen(final List<Citizen> citizenToSave) {
        CSVReaderWriter.write(filePath, citizenToSave, citizen -> {
            String[] fields = new String[5];
            fields[0] = citizen.getIdNumber().toString();
            fields[1] = citizen.getName();
            fields[2] = citizen.getDateOfBirth().toString();
            fields[3] = citizen.getNationality();
            fields[4] = Boolean.toString(citizen.getIsForeigner());

            return fields;
        });
    }

    public void saveCitizenWithReflection(final List<Citizen> citizenToSave) throws IOException {
        CSVReaderWriter.write(filePath, citizenToSave);
    }
}
