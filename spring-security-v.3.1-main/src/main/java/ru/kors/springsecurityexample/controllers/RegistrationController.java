package ru.kors.springsecurityexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kors.springsecurityexample.models.MyUser;
import ru.kors.springsecurityexample.repository.UserRepository;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new MyUser());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(MyUser user, Model model) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("error", "Пароли не совпадают");
            return "register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER"); // Установка роли по умолчанию
        userRepository.save(user);
        return "redirect:/login";
    }
}
