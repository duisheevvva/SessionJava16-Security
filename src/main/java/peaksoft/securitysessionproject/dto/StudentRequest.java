package peaksoft.securitysessionproject.dto;

import lombok.Builder;

@Builder
public record StudentRequest(
        String firstName,
        String lastName,
        String phoneNumber,
        String email,
        String password,
        String studyFormat
) {
}
