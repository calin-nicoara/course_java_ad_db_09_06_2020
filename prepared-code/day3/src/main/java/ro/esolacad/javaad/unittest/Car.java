package ro.esolacad.javaad.unittest;

import java.math.BigDecimal;
import java.util.Objects;

class Car {

    private String serialNumber;
    private String brand;
    private BigDecimal price;
    private String customParts;
    private OverallCondition condition;

    public Car(final String serialNumber,
               final String brand,
               final BigDecimal price, final
               String customParts,
               final OverallCondition condition) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.price = price;
        this.customParts = customParts;
        this.condition = condition;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(final String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public String getCustomParts() {
        return customParts;
    }

    public void setCustomParts(final String customParts) {
        this.customParts = customParts;
    }

    public OverallCondition getCondition() {
        return condition;
    }

    public void setCondition(final OverallCondition condition) {
        this.condition = condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, customParts, condition);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Car car = (Car) o;
        return Objects.equals(brand, car.brand) &&
                Objects.equals(price, car.price) &&
                Objects.equals(customParts, car.customParts) &&
                condition == car.condition;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", customParts='" + customParts + '\'' +
                ", condition=" + condition +
                '}';
    }

    enum OverallCondition {
        NEW, USED, POOR
    }
}
