package ro.esolacad.javaad.designpatterns.templatemethod;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineParserTest {

    @Test
    public void createCsvLineParser() {
        LineParser csvLineParser = new CsvLineParser();

        List<String> csvLines = csvLineParser.getLines("MOCK_FILE");

        assert csvLines.containsAll(Arrays.asList("MOCKED CSV", "ROW 2", "MOCK_FILE"));
    }

    @Test
    public void createExcelLineParser() {
        LineParser excelLineParser = new ExcelLineParser();

        List<String> excelLines = excelLineParser.getLines("MOCK_EXCEL_FILE");

        assert excelLines != null;

        System.out.println(excelLines);
    }
}
