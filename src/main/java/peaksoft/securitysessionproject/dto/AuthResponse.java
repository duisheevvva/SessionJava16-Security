package peaksoft.securitysessionproject.dto;

import lombok.Builder;
import peaksoft.securitysessionproject.enums.Role;

@Builder
public record AuthResponse(
        String token,
        Role role
) {

}
