package ro.esolacad.javaad.annotation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnnotatedClassTest {
    @Test
    public void testDeprecated() {
        Date date = new Date();

        List bearList = new ArrayList();

        testARgs("1", "2", "3");
    }

    public void testARgs(String... args) {
    }

}
