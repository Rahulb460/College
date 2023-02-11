package com.example.College.Converter;

import com.example.College.Models.Students;
import com.example.College.RequestDtos.StudentRequestDto;

public class StudentConverter {

    public static Students convertDtoToEntity(StudentRequestDto studentRequestDto) {
        Students student = Students.builder().name(studentRequestDto.getName())
                .branchName(studentRequestDto.getBranchName())
                .rollNo(studentRequestDto.getRollNo()).marks(studentRequestDto.getMarks()).build();

        return student;
    }
}
