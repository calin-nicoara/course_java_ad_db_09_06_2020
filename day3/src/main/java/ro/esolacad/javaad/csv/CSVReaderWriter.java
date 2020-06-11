package ro.esolacad.javaad.csv;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReaderWriter {

    public static <T> List<T> read(String filePath, Function<String[], T> rowMapper) throws IOException {
        return Files
                .readAllLines(Paths.get(filePath))
                .stream()
                .map(line -> line.split(","))
                .map(rowMapper)
                .collect(Collectors.toList());
    }

    public static <T> void write(final String filePath,
                                 List<T> citizenList,
                                 Function<T, String[]> rowMapper) {
        List<String> collect = citizenList.stream()
                .map(rowMapper)
                .map(rowFields -> String.join(",", rowFields))
                .collect(Collectors.toList());

        try {
            Files.write(Paths.get(filePath), collect);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File could not be written");
        }
    }

    public static <T> void write(final String filePath, final List<T> citizenToSave)
       throws IOException{

        write(filePath, citizenToSave, CSVReaderWriter::objectToCellsWithFields);
    }

    private static <T> String[] objectToCellsWithFields(T value) {
        List<String> collect = Stream.of(value.getClass().getDeclaredFields())
                .map(field -> {
                    field.setAccessible(true);
                    try {
                        return field.get(value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    return "";
                })
                .map(Objects::toString)
                .collect(Collectors.toList());

        return collect.toArray(new String[]{});
    }
}
