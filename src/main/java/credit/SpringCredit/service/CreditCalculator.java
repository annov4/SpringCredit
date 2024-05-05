package credit.SpringCredit.service;

import credit.SpringCredit.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CreditCalculator {

    @Value("${loan.minimalIncome}")
    private int minimalIncome;

    @Value("${loan.minCarValue}")
    private int minCarValue;

    public double calculateApprovedAmount(User user) {
        double approvedAmount = 0;

        double income = user.getIncome() == null ? 0 : user.getIncome();

        if (income > minimalIncome) {
            approvedAmount = income * 12 * 0.5;
        }
        if (user.getCar() != null && user.getCar().getPrice() > minCarValue) {
            approvedAmount = user.getCar().getPrice() * 0.3;
        }

        return approvedAmount;
    }
}
