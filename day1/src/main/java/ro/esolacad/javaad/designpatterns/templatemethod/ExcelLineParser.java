package ro.esolacad.javaad.designpatterns.templatemethod;

import java.util.Arrays;
import java.util.List;

public class ExcelLineParser extends LineParser{
    @Override
    protected List<String> getLinesFromFile(final String header, final String file) {
        return Arrays.asList("EXCEL PARSER", header, file);
    }

    @Override
    protected String getHeader(final String file) {
        return "EXCEL_HEADER";
    }
}
