package peaksoft.securitysessionproject.service;

import org.springframework.stereotype.Service;
import peaksoft.securitysessionproject.dto.SimpleResponse;
import peaksoft.securitysessionproject.dto.UserRequest;

@Service
public interface UserService {
    SimpleResponse saveUser(UserRequest userRequest);
}
