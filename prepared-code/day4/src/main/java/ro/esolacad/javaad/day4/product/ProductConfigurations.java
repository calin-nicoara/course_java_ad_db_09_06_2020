package ro.esolacad.javaad.day4.product;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "product")
@ConstructorBinding
public class ProductConfigurations {

    private final String externalService;
    private final Boolean hypermarketMode;

    public ProductConfigurations(final String externalService,
                                 final Boolean hypermarketMode) {
        this.externalService = externalService;
        this.hypermarketMode = hypermarketMode;
    }

    public String getExternalService() {
        return externalService;
    }

    public Boolean getHypermarketMode() {
        return hypermarketMode;
    }
}
