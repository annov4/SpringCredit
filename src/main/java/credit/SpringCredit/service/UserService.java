package credit.SpringCredit.service;

import credit.SpringCredit.model.User;
import credit.SpringCredit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final IncomeService incomeService;

    @Autowired
    public UserService(UserRepository userRepository, IncomeService incomeService) {
        this.userRepository = userRepository;
        this.incomeService = incomeService;
    }

    public User getUserWithIncome(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User not found"));
        int income = incomeService.getIncome().getValue();
        user.setIncome(income);
        return user;
    }
}