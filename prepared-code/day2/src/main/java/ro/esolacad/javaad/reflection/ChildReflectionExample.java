package ro.esolacad.javaad.reflection;

import java.time.LocalDateTime;

public class ChildReflectionExample extends ReflectionExample implements Shoutout {

    @AnnotationForReflection(isSpecial = true)
    public String nickname = "Nick";
    @AnnotationForReflection(isSpecial = true)
    private String childName;
    private LocalDateTime childDate = LocalDateTime.now();

    private ChildReflectionExample() {

    }

    public ChildReflectionExample(String childName) {
        super("I am child!");
        this.childName = childName;
    }

    public ChildReflectionExample(LocalDateTime localDateTime) {
        this.childDate = localDateTime;
    }

    private void privateMethod() {
        System.out.println("I am a private method!");
    }

    public String getName() {
        return childName;
    }

    @Override
    public void shoutout() {
        System.out.println("YO!");
    }
}
