package ro.esolacad.javaad.designpatterns.templatemethod;

import java.util.List;

public abstract class LineParser {

    public List<String> getLines(String filePath) {

        String file = readFile(filePath);
        String header = getHeader(file);

        return getLinesFromFile(header, file);
    }

    protected abstract List<String> getLinesFromFile(final String header, final String file) ;

    protected abstract String getHeader(final String file);

    protected String readFile(final String filePath) {
        return filePath;
    }
}
