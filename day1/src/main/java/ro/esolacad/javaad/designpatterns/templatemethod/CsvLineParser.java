package ro.esolacad.javaad.designpatterns.templatemethod;

import java.util.Arrays;
import java.util.List;

public class CsvLineParser extends LineParser {

    @Override
    public List<String> getLinesFromFile(final String header, final String file) {
        return Arrays.asList("MOCKED CSV", "ROW 2", file);
    }

    @Override
    public String getHeader(final String file) {
        return null;
    }
}
