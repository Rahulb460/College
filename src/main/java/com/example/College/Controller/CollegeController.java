package com.example.College.Controller;


import com.example.College.RequestDtos.BranchRequestDto;
import com.example.College.RequestDtos.StudentRequestDto;
import com.example.College.Service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    CollegeService collegeService;

    // Add a branch
    @PostMapping("/add_branch")
    public ResponseEntity<String> addBranch(@RequestBody() BranchRequestDto branchRequestDto) throws Exception {
        String result = collegeService.addBranch(branchRequestDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    // Add a student
    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody()StudentRequestDto studentRequestDto) throws Exception {
        String result = collegeService.addStudent(studentRequestDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/list_of_contactNo")
    public ResponseEntity<List<String>> listOfContactNo() {
        List<String> listOfContactNo = collegeService.listOfContactNo();
        return new ResponseEntity<>(listOfContactNo, HttpStatus.FOUND);
    }

    @GetMapping("/list_of_rollNo")
    public ResponseEntity<List<Integer>> listOfRollNo() {
        List<Integer> listOfRollNo = collegeService.listOfRollNo();
        return new ResponseEntity<>(listOfRollNo, HttpStatus.FOUND);
    }

    @GetMapping("/find_the_grant")
    public ResponseEntity<Integer> findGrant() {
        Integer ans = collegeService.findGrant();
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }



}
