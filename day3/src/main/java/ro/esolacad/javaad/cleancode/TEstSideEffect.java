package ro.esolacad.javaad.cleancode;

public class TEstSideEffect {

    private String parameter;

    public String getParameter() {
        // saveParameter to anotther database
        //

        return parameter;
    }

    public void setParameter(final String parameter) {
        this.parameter = parameter;
    }
}
