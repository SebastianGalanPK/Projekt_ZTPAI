package com.ztpai.projekt.meeme.auth;

import com.ztpai.projekt.meeme.config.JwtService;
import com.ztpai.projekt.meeme.data.User;
import com.ztpai.projekt.meeme.repository.RoleRepository;
import com.ztpai.projekt.meeme.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;

    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    private final DataVerification verification;

    @Autowired
    private HttpServletResponse httpServletResponse;


    public AuthenticationResponse register(RegisterRequest request, @NonNull HttpServletResponse response){
        String verification;

        verification = this.verification.checkLogin(request.getLogin());
        if(verification != null){
            return AuthenticationResponse.builder().message(verification).build();
        }

        verification = this.verification.checkPassword(request.getPassword());
        if(verification!=null){
            return AuthenticationResponse.builder().message(verification).build();
        }

        verification = this.verification.checkEmail(request.getEmail());
        if(verification!=null){
            return AuthenticationResponse.builder().message(verification).build();
        }

        Optional<User> userFromRepository = repository.findByLogin(request.getLogin());
        if(userFromRepository.isPresent()){
            return AuthenticationResponse.builder().message("This login is already taken").build();
        }

        var user = User.builder()
                .login(request.getLogin())
                .email(request.getEmail())
                .role(roleRepository.findById(1))
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        repository.save(user);

        var jwtToken = jwtService.generateToken(user);

        saveCookie(response, jwtToken);

        return AuthenticationResponse.builder().token(jwtToken).message("Succeed").build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request, @NonNull HttpServletResponse response) {
        Optional<User> userFromRepo = repository.findByLogin(request.getLogin());

        if(userFromRepo.isEmpty()){
            return AuthenticationResponse.builder().message("There is no user with given login and password!").build();
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getPassword()
                )
        );

        var user = repository.findByLogin(request.getLogin()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        saveCookie(response, jwtToken);

        return AuthenticationResponse.builder().token(jwtToken).message("Succeed").build();
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
