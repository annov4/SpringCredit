package credit.SpringCredit.service;

import credit.SpringCredit.model.Income;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class IncomeService {

    private final RestTemplate restTemplate;

    public Income getIncomeForUser(Long userId) {
        String url = "https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income";
        Income[] incomes = restTemplate.getForObject(url, Income[].class);
        if (incomes != null) {
            for (Income income : incomes) {
                if (income.getUserId() == userId) {
                    return income;
                }
            }
        }
        return new Income(userId, 0);

    }
}
