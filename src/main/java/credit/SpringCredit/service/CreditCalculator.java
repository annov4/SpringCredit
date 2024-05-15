package credit.SpringCredit.service;

import com.example.spring_boot_starter.client.IncomeClient;
import credit.SpringCredit.config.LoanProperties;
import credit.SpringCredit.model.User;
import org.springframework.stereotype.Service;

@Service
public class CreditCalculator {

    private final LoanProperties loanProperties;
    private final IncomeClient incomeClient;


    public CreditCalculator(LoanProperties loanProperties, IncomeClient incomeClient) {
        this.loanProperties = loanProperties;
        this.incomeClient = incomeClient;
    }

    public double calculateApprovedAmount(User user) {
        double income = incomeClient.getIncomeForUser(user.getId()).getIncome();
        double approvedAmount = 0;

        if (user.getCar() != null && user.getCar().getPrice() > loanProperties.getMinCarValue()) {
            approvedAmount = user.getCar().getPrice() * loanProperties.getPercentOfCarValue();
        }
        if (income > loanProperties.getMinimalIncome()) {
            approvedAmount = Math.max(approvedAmount, income * 12 * loanProperties.getPercentOfIncome());
        }

        return approvedAmount;

    }
}
