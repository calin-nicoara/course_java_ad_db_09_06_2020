package ro.esolacad.javaad.oop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class User implements NameIdentifier, EarningsReporter
//        ,Comparable<User>
{

    private String id;
    private BigDecimal annualSalary;

    public User() {
        this.id = "DEFAULT";
        this.annualSalary = BigDecimal.valueOf(0);
    }

    public User(String id, BigDecimal annualSalary) {
        this.id = id;
        this.annualSalary = annualSalary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(final BigDecimal annualSalary) {
        this.annualSalary = annualSalary;
    }

    public BigDecimal getMonthlySalary() {
        return annualSalary.divide(BigDecimal.valueOf(12), 2, RoundingMode.DOWN);
    }

    protected String getForChild() {
        return "Hello, my child!";
    }

    @Override
    public String getName() {
        return "I am a User!";
    }

    @Override
    public BigDecimal getLifetimeEarnings() {
        return annualSalary.multiply(BigDecimal.valueOf(40));
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", annualSalary=" + annualSalary +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(id, user.id) &&
                ((annualSalary != null && user.annualSalary != null && annualSalary.compareTo(user.annualSalary) == 0)
                || (annualSalary == null && user.annualSalary == null));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, annualSalary.setScale(4, RoundingMode.FLOOR));
    }

//    @Override
//    public int compareTo(final User otherUser) {
//        return id.compareTo(otherUser.id);
//    }
}
