package ro.esolacad.javaad.unittest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class CarShopMockTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarRepairShop carRepairShop;

    @Test
    public void testSaveCar() {
        Car car = new Car("0001", "FORD",
                BigDecimal.valueOf(12000), "CHROME RIMS", Car.OverallCondition.NEW);

        Mockito.when(carRepository.save(car)).thenReturn("mocked0001");
        String serialNumber = carRepairShop.saveCar(car);

        Assertions.assertEquals(serialNumber, "mocked0001");

        Mockito.verify(carRepository, times(1)).save(car);

        Mockito.verifyNoMoreInteractions(carRepository);
    }
}
