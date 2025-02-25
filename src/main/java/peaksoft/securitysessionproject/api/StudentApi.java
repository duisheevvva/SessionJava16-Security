package peaksoft.securitysessionproject.api;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.securitysessionproject.dto.SimpleResponse;
import peaksoft.securitysessionproject.dto.StudentRequest;
import peaksoft.securitysessionproject.service.StudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentApi {
   private final StudentService studentService;


   @PreAuthorize("hasRole('ADMIN')") // 2
   @PostMapping("/save")
    public SimpleResponse saveStudent(@RequestBody StudentRequest studentRequest){
       return studentService.saveStudent(studentRequest);
   }

   @PreAuthorize("hasRole('STUDENT')") // 2
   @PutMapping ("/{id}")
   public SimpleResponse updateStudent(@PathVariable Long id,@RequestBody StudentRequest studentRequest){
      return studentService.updateStudent(id,studentRequest);
   }

}
