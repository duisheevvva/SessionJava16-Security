package peaksoft.securitysessionproject.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.securitysessionproject.config.jwtConfig.JwtService;
import peaksoft.securitysessionproject.dto.AuthResponse;
import peaksoft.securitysessionproject.dto.SimpleResponse;
import peaksoft.securitysessionproject.dto.SingInRequest;
import peaksoft.securitysessionproject.dto.SingUpRequest;
import peaksoft.securitysessionproject.entities.User;
import peaksoft.securitysessionproject.enums.Role;
import peaksoft.securitysessionproject.repo.UserRepo;
import peaksoft.securitysessionproject.service.AuthService;
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    // Bcrypt encode /decode
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    @Override
    public AuthResponse singUp(SingUpRequest singUpRequest) {
        if (userRepo.existsByEmail(singUpRequest.email())){
            throw new  RuntimeException(String.format(" User with email %s  already exist " , singUpRequest.email()));
        }
        User user = User
                .builder()
                .firstName(singUpRequest.firstName())
                .lastName(singUpRequest.lastName())
                .phoneNumber(singUpRequest.phoneNumber())
                .email(singUpRequest.email())
                .password(passwordEncoder.encode(singUpRequest.password()))
                .role(Role.USER)
                .build();
        userRepo.save(user);

        String token = jwtService.generateToken(user);

        return AuthResponse
                .builder()
                .token(token)
                .role(user.getRole())
                .build();
    }

    // Auth

    @Override
    public AuthResponse singIn(SingInRequest singInRequest) {
        User user = userRepo.findUserByEmail(singInRequest.email()).orElseThrow(()
                -> new EntityNotFoundException(String.format("User with email %s not found!", singInRequest.email())));
        if (!passwordEncoder.matches(singInRequest.password(),user.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }

        String token = jwtService.generateToken(user);

        return AuthResponse
                .builder()
                .token(token)
                .role(user.getRole())
                .build();
    }
}
