package credit.SpringCredit.service;

import credit.SpringCredit.model.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IncomeService {
    private final RestTemplate restTemplate;

    @Autowired
    public IncomeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Income getIncome() {
        String url = "https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income";
        return restTemplate.getForObject(url, Income.class);
    }
}
