package ro.esolacad.javaad.day4.product;

public class TestBuilder {

    private String name;

    public TestBuilder(final String name) {
        this.name = name;
    }

    public TestBuilder() {

    }

    public static TestBuilderBuilder builder() {
        return new TestBuilderBuilder();
    }

    public String getName() {
        return name;
    }

    public static class TestBuilderBuilder {
        private final TestBuilder testBuilder = new TestBuilder();

        private TestBuilderBuilder() {
        }

        public TestBuilderBuilder name(String name) {
            testBuilder.name = name;
            return this;
        }

        public TestBuilder build() {
            return testBuilder;
        }
    }
}
