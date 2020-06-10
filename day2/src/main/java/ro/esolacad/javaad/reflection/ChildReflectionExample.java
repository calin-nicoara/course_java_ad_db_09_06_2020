package ro.esolacad.javaad.reflection;

public class ChildReflectionExample extends ReflectionExample{

    private String childParam;

    public ChildReflectionExample(final String childParam) {
        this.childParam = childParam;
    }

    public ChildReflectionExample(final String publicValue, final String childParam) {
        super(publicValue);
        this.childParam = childParam;
    }

    public String getChildParam() {
        return childParam;
    }
}
