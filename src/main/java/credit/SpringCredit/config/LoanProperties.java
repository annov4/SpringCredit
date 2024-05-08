package credit.SpringCredit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "loan")
public class LoanProperties {

    private int minimalIncome;
    private int minCarValue;
    private double percentOfIncome;
    private double percentOfCarValue;

    public int getMinimalIncome() {
        return minimalIncome;
    }

    public int getMinCarValue() {
        return minCarValue;
    }

    public double getPercentOfIncome() {
        return percentOfIncome;
    }

    public double getPercentOfCarValue() {
        return percentOfCarValue;
    }

    public void setMinimalIncome(int minimalIncome) {
        this.minimalIncome = minimalIncome;
    }

    public void setMinCarValue(int minCarValue) {
        this.minCarValue = minCarValue;
    }

    public void setPercentOfIncome(double percentOfIncome) {
        this.percentOfIncome = percentOfIncome;
    }

    public void setPercentOfCarValue(double percentOfCarValue) {
        this.percentOfCarValue = percentOfCarValue;
    }

}

