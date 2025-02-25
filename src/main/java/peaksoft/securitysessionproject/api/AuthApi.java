package peaksoft.securitysessionproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.securitysessionproject.dto.*;
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

    @GetMapping
    public ProfileResponse getProfile(){
        return  authService.getProfile();
    }


}
