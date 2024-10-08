package com.rb.skiply.student_service.service;

import com.rb.skiply.student_service.entity.Student;
import com.rb.skiply.student_service.openapi.model.StudentRequest;
import com.rb.skiply.student_service.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class StudentEnrollServiceImpl implements StudentEnrollService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Student enrollStudent(StudentRequest studentRequest) {
        final Student student = convertStudentRequest(studentRequest);
        final Student studentSaved = studentRepository.save(student);
        return studentSaved;
    }

    private Student convertStudentRequest(StudentRequest studentRequest) {
        return Student.builder()
                .studentId(studentRequest.getStudentId())
                .grade(studentRequest.getGrade().getValue())
                .mobileNumber(studentRequest.getMobileNumber())
                .studentName(studentRequest.getStudentName())
                .schoolName(studentRequest.getSchoolName())
                .build();
    }


    @Override
    public Student updateStudent(StudentRequest studentRequest) {
        //Not implemented
        return null;
    }
}
