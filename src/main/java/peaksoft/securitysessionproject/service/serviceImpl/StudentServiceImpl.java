package peaksoft.securitysessionproject.service.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.securitysessionproject.dto.SimpleResponse;
import peaksoft.securitysessionproject.dto.StudentRequest;
import peaksoft.securitysessionproject.entities.Student;
import peaksoft.securitysessionproject.entities.User;
import peaksoft.securitysessionproject.enums.Role;
import peaksoft.securitysessionproject.repo.StudentRepo;
import peaksoft.securitysessionproject.repo.UserRepo;
import peaksoft.securitysessionproject.service.StudentService;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public SimpleResponse saveStudent(StudentRequest studentRequest) {
        User user = User
                .builder()
                .firstName(studentRequest.firstName())
                .lastName(studentRequest.lastName())
                .phoneNumber(studentRequest.phoneNumber())
                .email(studentRequest.email())
                .password(passwordEncoder.encode(studentRequest.password()))
                .role(Role.STUDENT)
                .build();
        userRepo.save(user);
        Student student = Student
                .builder()
                .studyFormat(studentRequest.studyFormat())
                .user(user)
                .build();
        studentRepo.save(student);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Success")
                .build();
    }

    @Override
    public SimpleResponse updateStudent(Long id, StudentRequest studentRequest) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepo.findUserByEmail(email).orElseThrow(()
                -> new EntityNotFoundException(String.format("User with email %s not found!", email)));

        User updateUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("Not Found")));
        if (currentUser.getEmail().equals(updateUser.getEmail())){
            updateUser.setFirstName(studentRequest.firstName());
            updateUser.setLastName(studentRequest.lastName());
            updateUser.setPhoneNumber(studentRequest.phoneNumber());
            updateUser.setEmail(studentRequest.email());
            updateUser.setPassword(studentRequest.password());
            userRepo.save(updateUser);
        }else {
            throw new RuntimeException(String.format("eroro"));
        }

        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Success updated")
                .build();
    }


}
