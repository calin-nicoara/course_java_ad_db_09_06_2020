package ro.esolacad.javaad.designpatterns.template;

import org.junit.jupiter.api.Test;

class LineParserTest {

    @Test
    public void testCsvParser() {
        String absolutePath = "/home/calin-nicoara/IdeaProjects/courses/course_java_advanced/final/day1/src/test/resources/test.txt";

        LineParser lineParser = new CsvLineParser();

        lineParser.getLines(absolutePath);
    }

    @Test
    public void testExcelParser() {
        String absolutePath = "/home/calin-nicoara/IdeaProjects/courses/course_java_advanced/final/day1/src/test/resources/test.txt";

        LineParser lineParser = new ExcelLineParser();

        lineParser.getLines(absolutePath);
    }

}
