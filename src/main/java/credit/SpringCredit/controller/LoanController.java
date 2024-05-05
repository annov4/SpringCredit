package credit.SpringCredit.controller;


import credit.SpringCredit.model.User;
import credit.SpringCredit.service.CreditCalculator;
import credit.SpringCredit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/loan")
public class LoanController {

    private final UserService userService;

    @Autowired
    private CreditCalculator creditCalculator;

    public LoanController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String approveLoan(@RequestParam(value = "userId") Long userId, Model model) {
        User userWithIncome = userService.getUserWithIncome(userId);
        double approvedAmount = creditCalculator.calculateApprovedAmount(userWithIncome);

        model.addAttribute("user", userWithIncome);
        model.addAttribute("approvedAmount", approvedAmount);

        if (approvedAmount > 0) {
            return "loanApproved";
        } else {
            return "loanRejected";
        }
    }
}