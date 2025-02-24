package peaksoft.securitysessionproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.securitysessionproject.dto.AuthResponse;
import peaksoft.securitysessionproject.dto.SimpleResponse;
import peaksoft.securitysessionproject.dto.SingInRequest;
import peaksoft.securitysessionproject.dto.SingUpRequest;
import peaksoft.securitysessionproject.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthApi {
    private final AuthService authService;


    @PostMapping("/singUp")
    public AuthResponse singUp(@RequestBody SingUpRequest singUpRequest){
       return  authService.singUp(singUpRequest);
    }

    @PostMapping("/singIn")
    public AuthResponse singIn(@RequestBody SingInRequest singInRequest){
        return authService.singIn(singInRequest);
    }


}
