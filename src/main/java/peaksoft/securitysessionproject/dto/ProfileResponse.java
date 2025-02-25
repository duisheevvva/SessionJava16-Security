package peaksoft.securitysessionproject.dto;

import lombok.Builder;
import peaksoft.securitysessionproject.enums.Role;

@Builder
public record ProfileResponse(
        Long id,
        String email,
        Role role
) {

}
