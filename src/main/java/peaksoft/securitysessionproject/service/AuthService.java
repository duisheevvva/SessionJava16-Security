package peaksoft.securitysessionproject.service;

import org.springframework.stereotype.Service;
import peaksoft.securitysessionproject.dto.AuthResponse;
import peaksoft.securitysessionproject.dto.ProfileResponse;
import peaksoft.securitysessionproject.dto.SingInRequest;
import peaksoft.securitysessionproject.dto.SingUpRequest;

@Service
public interface AuthService {
   AuthResponse singUp (SingUpRequest singUpRequest);
   AuthResponse singIn(SingInRequest singInRequest);
   ProfileResponse getProfile();

}
