package ru.kors.springsecurityexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kors.springsecurityexample.models.Deposit;
import ru.kors.springsecurityexample.services.ExternalDepositService;
import java.util.List;

@Controller
@RequestMapping("/deposits")
public class DepositController {

    @Autowired
    private ExternalDepositService depositService;

    @GetMapping
    public String getDepositsByUserId(Model model, @RequestParam("userId") Long userId) {
        List<Deposit> deposits = depositService.getDepositsByUserId(userId);
        model.addAttribute("deposits", deposits);
        model.addAttribute("userId", userId);
        return "deposits";
    }

    @PostMapping
    public String addDeposit(@ModelAttribute Deposit deposit) {
        depositService.addDeposit(deposit);
        return "redirect:/deposits?userId=" + deposit.getUserId();
    }

    @GetMapping("/new")
    public String showAddDepositForm(Model model) {
        model.addAttribute("deposit", new Deposit());
        return "add-deposit";
    }

    @GetMapping("/{depositId}")
    public String viewDepositDetails(@PathVariable Long depositId, Model model) {
        Deposit deposit = depositService.getDepositById(depositId);
        model.addAttribute("deposit", deposit);
        return "deposit-details";
    }
}
