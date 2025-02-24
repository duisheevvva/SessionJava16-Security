package peaksoft.securitysessionproject.dto;

import lombok.Builder;

@Builder
public record SingUpRequest(
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String password
) {
}
