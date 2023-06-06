package com.ztpai.projekt.meeme.auth;

import com.ztpai.projekt.meeme.config.JwtService;
import com.ztpai.projekt.meeme.data.User;
import com.ztpai.projekt.meeme.repository.RoleRepository;
import com.ztpai.projekt.meeme.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request, @NonNull HttpServletResponse response){
        var user = User.builder()
                .login(request.getLogin())
                .email(request.getEmail())
                .role(roleRepository.findById(1))
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        repository.save(user);

        var jwtToken = jwtService.generateToken(user);

        saveCookie(response, jwtToken);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request, @NonNull HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        var user = repository.findByLogin(request.getLogin()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        saveCookie(response, jwtToken);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    private void saveCookie(@NonNull HttpServletResponse response, String jwtToken){
        // Utworzenie obiektu ciasteczka
        Cookie cookie = new Cookie("jwtToken", jwtToken);
        // Ustawienie ścieżki, na której ma być dostępne ciasteczko
        cookie.setPath("/");
        // Ustawienie czasu wygaśnięcia ciasteczka (opcjonalne)
        cookie.setMaxAge(24 * 60 * 60); // Na przykład 24 godziny
        // Dodanie ciasteczka do odpowiedzi
        response.addCookie(cookie);
    }
}
