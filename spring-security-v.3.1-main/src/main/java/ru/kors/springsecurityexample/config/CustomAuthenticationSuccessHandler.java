package ru.kors.springsecurityexample.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.kors.springsecurityexample.repository.UserRepository;
import ru.kors.springsecurityexample.models.MyUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository userRepository;

    public CustomAuthenticationSuccessHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<MyUser> userOptional = userRepository.findByName(userDetails.getUsername());

        if (userOptional.isPresent()) {
            Long userId = userOptional.get().getId();
            response.sendRedirect("/deposits?userId=" + userId);
        } else {
            response.sendRedirect("/login?error=true");
        }
    }
}
