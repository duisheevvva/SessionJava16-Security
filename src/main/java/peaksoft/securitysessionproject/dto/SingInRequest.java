package peaksoft.securitysessionproject.dto;

import lombok.Builder;

@Builder
public record SingInRequest(
        String email,
        String password
) {
}
