package ro.esolacad.javaad.oop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SuperUser extends User{

    private User user;

    public SuperUser() {
        super();
    }

    public SuperUser(String id, BigDecimal salary, boolean superAdmin) {
        super(id, salary);
        this.superAdmin = superAdmin;
    }

    private boolean superAdmin;

    public boolean isSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(final boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    @Override
    public BigDecimal getMonthlySalary() {
        return getAnnualSalary().divide(BigDecimal.valueOf(12), 2, RoundingMode.DOWN)
                .multiply(BigDecimal.valueOf(1.1));
    }

    @Override
    public String getForChild() {
        return super.getForChild();
    }
}
