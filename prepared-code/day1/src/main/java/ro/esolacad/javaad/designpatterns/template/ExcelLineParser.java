package ro.esolacad.javaad.designpatterns.template;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class ExcelLineParser extends LineParser {

    @Override
    public String getHeader(final InputStream file) {
        System.out.println("GET HEADER FOR EXCEL");
        return null;
    }

    @Override
    public List<String> getLinesFromFile(final String header, final InputStream file) {
        System.out.println("GET LINES FOR EXCEL");
        return new ArrayList<>();
    }
}
