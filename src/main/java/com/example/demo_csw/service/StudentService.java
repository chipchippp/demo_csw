package com.example.demo_csw.service;

import com.example.demo_csw.constant.CommonDefine;
import com.example.demo_csw.dto.ResponseEntity;
import com.example.demo_csw.entity.Student;
import com.example.demo_csw.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity getAllStudents() {
        ResponseEntity responseEntity = new ResponseEntity();
        try {
            responseEntity.setCode(CommonDefine.SUCCESS_CODE);
            responseEntity.setMessage(CommonDefine.SUCCESS_MESSAGE);
            List<Object> students = List.of(studentRepository.findAll().toArray());
            responseEntity.setData(students);

        }catch (Exception e){
            responseEntity.setCode(CommonDefine.ERROR_CODE);
            responseEntity.setMessage(e.getMessage());
            return responseEntity;
        }
        return responseEntity;
    }
}