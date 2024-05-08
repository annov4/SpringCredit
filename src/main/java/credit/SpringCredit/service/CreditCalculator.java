package credit.SpringCredit.service;

import credit.SpringCredit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CreditCalculator {

    @Value("${loan.minimalIncome}")
    private int minimalIncome;

    @Value("${loan.minCarValue}")
    private int minCarValue;

    @Autowired
    private IncomeService incomeService;

    public double calculateApprovedAmount(User user) {
        double income = incomeService.getIncomeForUser(user.getId()).getIncome();
        double approvedAmount = 0;

        if (user.getCar() != null && user.getCar().getPrice() > minCarValue) {
            approvedAmount = user.getCar().getPrice() * 0.3;
        }
        if (income > minimalIncome) {
            approvedAmount = Math.max(approvedAmount, income * 12 * 0.5);
        }

        return approvedAmount;
    }
}
