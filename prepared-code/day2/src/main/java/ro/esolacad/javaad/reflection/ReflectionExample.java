package ro.esolacad.javaad.reflection;

public class ReflectionExample {

    public String publicValue;
    private String privateSecret;
    public static final String MESSAGE = "STATIC";

    public ReflectionExample() {
    }

    public ReflectionExample(String publicValue) {
        this.publicValue = publicValue;
        this.privateSecret = "secret";
    }

    public static void publicStaticMethod() {

    }

    private void privateMethod() {
        System.out.println("I am a private method!");
    }

    public void publicMethod() {
        System.out.println("I am a public method!");
    }

    public void publicMethod(String variable) {
        System.out.println(variable);
    }

    public String getMySecret() {
        return this.privateSecret;
    }

    public String getPublicValue() {
        return publicValue;
    }
}
