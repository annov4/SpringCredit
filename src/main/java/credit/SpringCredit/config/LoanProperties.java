package credit.SpringCredit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "loan")
@Getter
@Setter
public class LoanProperties {

    private int minimalIncome;
    private int minCarValue;
    private double percentOfIncome;
    private double percentOfCarValue;


}

