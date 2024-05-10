package credit.SpringCredit.service;

import credit.SpringCredit.config.LoanProperties;
import credit.SpringCredit.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditCalculator {

    private final LoanProperties loanProperties;
    private final IncomeService incomeService;

    public double calculateApprovedAmount(User user) {
        double income = incomeService.getIncomeForUser(user.getId()).getIncome();
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
