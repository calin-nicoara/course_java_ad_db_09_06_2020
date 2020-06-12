package ro.esolacad.javaad.lab;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVTest {

    @Test
    public void writeCsv() throws IOException {
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "Ion", "Popescu"));
        users.add(new User(2L, "Dan", "Dobrin"));
        users.add(new User(3L, "Bobby", "Popescu"));

        CSV.write("test.csv", users);
    }

    @Test
    void testReadString() throws IOException {
        List<String> citit = CSV.read("ex.csv", cells -> cells[1]);
        System.out.println(citit);
        assert citit != null;
    }

    @Test
    public void testReadUser() throws IOException {
        List<User> users = CSV.read("ex.csv", this::userFromCells);

        System.out.println(users);
        assert 2 == users.size();
    }

    private User userFromCells(String[] cells) {
        return new User(Long.valueOf(cells[0]), cells[1], cells[2]);
    }
}
