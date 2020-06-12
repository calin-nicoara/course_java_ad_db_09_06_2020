package ro.esolacad.javaad.annotations;


class MainAnnotation {

    public static void main(String[] args) {
        DeprecatedClass deprecatedClass = new DeprecatedClass();

        deprecatedClass.deprecatedMethod();

        FunctionalTest functionalTest = () -> System.out.println("good");

        functionalTest.test();
    }
}
