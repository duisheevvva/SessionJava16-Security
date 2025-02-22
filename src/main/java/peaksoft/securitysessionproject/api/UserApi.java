package peaksoft.securitysessionproject.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.securitysessionproject.dto.SimpleResponse;
import peaksoft.securitysessionproject.dto.UserRequest;
import peaksoft.securitysessionproject.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserApi {
    private final UserService userService;


    @PostMapping
    public SimpleResponse saveUser(@RequestBody UserRequest userRequest){
        return userService.saveUser(userRequest);
    }


}
