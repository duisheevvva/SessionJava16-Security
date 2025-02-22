package peaksoft.securitysessionproject.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.securitysessionproject.dto.SimpleResponse;
import peaksoft.securitysessionproject.dto.UserRequest;
import peaksoft.securitysessionproject.entities.User;
import peaksoft.securitysessionproject.enums.Role;
import peaksoft.securitysessionproject.repo.UserRepo;
import peaksoft.securitysessionproject.service.UserService;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SimpleResponse saveUser(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.firstName());
        user.setLastName(userRequest.lastName());
        user.setEmail(userRequest.email());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        user.setRole(Role.ADMIN);
        userRepo.save(user);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Success")
                .build();
    }
}
