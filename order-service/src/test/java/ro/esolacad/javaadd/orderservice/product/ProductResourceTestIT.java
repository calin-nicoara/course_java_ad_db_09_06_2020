package ro.esolacad.javaadd.orderservice.product;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductResourceTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Sql(value = "/sql/getProduct.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "/sql/deleteForGetProduct.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testGetProduct() throws Exception {
        ProductModel productModel = ProductModel.builder()
                .id(1L)
                .name("Kit-Kat")
                .stock(2L)
                .price(BigDecimal.valueOf(2).setScale(2))
                .status(ProductStatus.INACTIVE)
                .build();

        String expectedResult = objectMapper.writeValueAsString(productModel);

        MvcResult mvcResult = mockMvc
                .perform(get("/products/1").contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();


        Assertions.assertEquals(expectedResult, contentAsString);
    }
}
