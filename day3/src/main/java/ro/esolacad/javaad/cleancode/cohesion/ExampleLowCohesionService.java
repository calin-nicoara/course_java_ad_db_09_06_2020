package ro.esolacad.javaad.cleancode.cohesion;

public class ExampleLowCohesionService {

    private EmailService emailService;
    private ClientService clientService;
    private AuditService auditService;

//    public void sendEmail() {
////        emailService;
//    }
//
    public void sendClientReport() {
        // use clientService
        // use auditService
    }

    public String getClient() {
        // use clientService
        return null;
    }

    public void doAnnualReport() {
        // use clientService
        // use auditService
    }
}
