package ro.esolacad.javaad.lab;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @Test
    public void testCsvRead() throws Exception {
        List<Product> linesFromCsv = CSV.getLinesFromCsv("test.csv", rows -> {
            Product product = new Product();
            product.setProduct(rows[0]);
            product.setPrice(Integer.parseInt(rows[1]));
            product.setOutOfStock(Boolean.parseBoolean(rows[2]));

            return product;
        });

        System.out.println(linesFromCsv);
    }
}
