package credit.SpringCredit.controller;


import credit.SpringCredit.model.User;
import credit.SpringCredit.service.CreditCalculator;
import credit.SpringCredit.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/loan")
@AllArgsConstructor
public class LoanController {

    private final UserService userService;
    private final CreditCalculator creditCalculator;

    @GetMapping
    public String approveLoan(@RequestParam(value = "userId") Long userId, Model model) {

        User user = userService.findById(userId);

        double approvedAmount = creditCalculator.calculateApprovedAmount(user);

        model.addAttribute("user", user);
        model.addAttribute("approvedAmount", approvedAmount);

        return "loanApproved";

    }
}