package ro.esolacad.javaad.codequality.lowcouplinghighcohesion;

class HighCouplingLowCohesion {

    private ClientService clientService;
    private EmailService emailService;
    private InvoiceService invoiceService;
    private PdfService pdfService;

    public void createClient() {
        // use client service
    }

    public void sendEmail() {
        // use email service
    }

    public void createInvoice() {
        // use pdf service
        // use invoice service
    }
}
