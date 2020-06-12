package ro.esolacad.javaad.day4.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ProductResource2TestIT {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testWithRestTemplate() {
        ResponseEntity<String> exchange = restTemplate.exchange("/api/product",
                HttpMethod.GET, null, String.class);


        Assertions.assertThat(exchange.getBody()).isEqualTo("externalservice");
    }
}
