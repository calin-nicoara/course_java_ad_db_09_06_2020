package ro.esolacad.javaad.annotations;

@CustomAnnotation(
        name = "me",
        stringClass = String.class,
        createdAt = "yoday"
)
class ParentClass {

    @CustomAnnotation(
            name = "me",
            stringClass = String.class,
            createdAt = "yoday"
    )
    public void eat() {

    }
}
