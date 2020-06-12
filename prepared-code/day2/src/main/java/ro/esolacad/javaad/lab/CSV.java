package ro.esolacad.javaad.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSV {

    public static <T> List<T> read(String fileName, Function<String[], T> rowMapper) throws IOException {
        return Files.readAllLines(Paths.get(fileName)).stream().map(line -> line.split(",")).map(rowMapper)
                .collect(Collectors.toList());
    }

    public static <T> void write(String fileName, List<T> list, Function<T, String[]> rowMapper) throws IOException {
        List<String> lines = list.stream().map(rowMapper).map(cells -> String.join(",", cells)).collect(Collectors.toList());
        Files.write(Paths.get(fileName), lines);
    }

    public static <T> void write(String fileName, List<T> list) throws IOException {
        List<String> lines = list.stream().map(CSV::objectToCells)
                .map(cells -> String.join(",", cells)).collect(Collectors.toList());

        Files.write(Paths.get(fileName), lines);
    }

    private static <T> String[] objectToCells(T value) {
        List<String> cells = Stream.of(value.getClass().getDeclaredFields()).map(field -> {
            field.setAccessible(true);
            try {
                return field.get(value);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).map(Object::toString).collect(Collectors.toList());
        return cells.toArray(new String[]{});
    }
}
