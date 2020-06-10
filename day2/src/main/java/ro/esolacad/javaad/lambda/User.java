package ro.esolacad.javaad.lambda;

import java.util.Objects;

public class User {

    private Long id;
    private String name;
    private Boolean isEmployed;

    public User() {}

    public User(final Long id, final String name, final Boolean isEmployed) {
//        System.out.println("User created: " + id);
        this.id = id;
        this.name = name;
        this.isEmployed = isEmployed;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Boolean getEmployed() {
        return isEmployed;
    }

    public void setEmployed(final Boolean employed) {
        isEmployed = employed;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(isEmployed, user.isEmployed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isEmployed);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isEmployed=" + isEmployed +
                '}';
    }
}
