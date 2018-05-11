package com.test.service;

import com.test.bean.Student;
import com.test.repo.StudentRepo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class DataImportService {
    @Inject
    StudentRepo studentRepo;

    public Optional<Student> getStudent(Long rollNo) {
        Optional<Student> byRollNo = studentRepo.findByRollNo(rollNo);
        return byRollNo;
    }

}
