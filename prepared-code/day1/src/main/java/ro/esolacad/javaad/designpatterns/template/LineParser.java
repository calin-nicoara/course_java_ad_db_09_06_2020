package ro.esolacad.javaad.designpatterns.template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

abstract class LineParser {
    public final List<String> getLines(String filePath) {

        try (InputStream file = readFile(filePath)) {
            String header = getHeader(file);

            return getLinesFromFile(header, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    protected InputStream readFile(final String filePath) {
        try {
            return new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected abstract String getHeader(final InputStream file);

    protected abstract List<String> getLinesFromFile(final String header, final InputStream file);
}
