package peaksoft.securitysessionproject.service;

import peaksoft.securitysessionproject.dto.SimpleResponse;
import peaksoft.securitysessionproject.dto.StudentRequest;

public interface StudentService {
    SimpleResponse saveStudent(StudentRequest studentRequest);
    SimpleResponse updateStudent(Long id,StudentRequest studentRequest);

}
