package ro.esolacad.javaad.codequality.lowcouplinghighcohesion;

class LowCouplingHighCohesion3 {

    private InvoiceService invoiceService;
    private PdfService pdfService;

    public void createInvoice() {
        // use pdf service
        // use invoice service
    }
}
