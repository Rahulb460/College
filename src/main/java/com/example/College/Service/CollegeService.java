package com.example.College.Service;


import com.example.College.Converter.BranchConverter;
import com.example.College.Converter.StudentConverter;
import com.example.College.Models.Branch;
import com.example.College.Models.Students;
import com.example.College.Repository.BranchRepository;
import com.example.College.Repository.StudentRepository;
import com.example.College.RequestDtos.BranchRequestDto;
import com.example.College.RequestDtos.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeService {

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    StudentRepository studentRepository;


    public String addBranch(BranchRequestDto branchRequestDto) throws Exception {
        try {
            Branch branch = BranchConverter.convertDtoToEntity(branchRequestDto);
            branchRepository.save(branch);
        }
        catch (Exception e) {
            throw new Exception("Branch didn't added");
        }

        return "Branch added successfully";
    }


    public String addStudent(StudentRequestDto studentRequestDto) throws Exception {
        try {
            Students student = StudentConverter.convertDtoToEntity(studentRequestDto);
            int id = studentRequestDto.getBranchId();
            Branch branch = branchRepository.findById(id).get();
            student.setBranch(branch);
            studentRepository.save(student);
        }
        catch (Exception e) {
            throw new Exception("Student didn't added");
        }

        return "Student added successfully";
    }



    public List<String> listOfContactNo() {
         int count = 0;
         int ans = Integer.MIN_VALUE;

        List<String> contactNoList = new ArrayList<>();

        List<Branch> branchList = branchRepository.findAll();

        for (Branch branch : branchList) {
            List<Students> studentsList = branch.getStudentsList();
            for (Students student : studentsList) {
                if (student.getMarks() >= 40) {
                    count++;
                }
            }
            if(count >= ans) {
                ans = Math.max(ans, count);
                String phoneNo = branch.getContactNo();
                contactNoList.add(phoneNo);
            }
            count = 0;
        }
        return contactNoList;
    }

    public List<Integer> listOfRollNo() {
        int max = Integer.MIN_VALUE;  // max the id latest the branch

        List<Integer> rollNoList = new ArrayList<>();

        List<Branch> branchList = branchRepository.findAll();

        for(Branch branch : branchList) {
            max = Math.max(max, branch.getId());
        }

        Branch latestBranch = branchRepository.findById(max).get();
        List<Students> studentsList = latestBranch.getStudentsList();

        for (Students student : studentsList) {
            rollNoList.add(student.getRollNo());
        }

        return rollNoList;
    }


    public Integer findGrant() {
        int count = 0;
        int ans = Integer.MIN_VALUE;
        int grant = 0;

        List<Branch> branchList = branchRepository.findAll();

        for (Branch branch : branchList) {
            List<Students> studentsList = branch.getStudentsList();
            for (Students student : studentsList) {
                if (student.getMarks() >= 40) {
                    count++;
                }
            }
            if(count > ans) {
                ans = Math.max(ans, count);
                grant = branch.getGrant();
            }
            count = 0;
        }
        return grant;
    }
}
