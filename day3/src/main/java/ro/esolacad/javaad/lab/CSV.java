package ro.esolacad.javaad.lab;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CSV {

    public static <T> List<T> getLinesFromCsv(String filePath,
                                              Function<String[], T> rowMapper) throws Exception{
        return Files.readAllLines(Paths.get(filePath))
                .stream()
                .map(s -> rowMapper.apply(s.split(",")))
                .collect(Collectors.toList());
    }
}
