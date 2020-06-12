package ro.esolacad.javaad.designpatterns.template;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class CsvLineParser extends LineParser {

    @Override
    public String getHeader(final InputStream file) {
        System.out.println("GET HEADER FOR CSV");
        return null;
    }

    @Override
    public List<String> getLinesFromFile(final String header, final InputStream file) {
        System.out.println("GET LINES FOR CSV");
        return new ArrayList<>();
    }
}
