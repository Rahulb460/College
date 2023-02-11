package com.example.College.Converter;

import com.example.College.Models.Branch;
import com.example.College.RequestDtos.BranchRequestDto;

public class BranchConverter {

    public static Branch convertDtoToEntity(BranchRequestDto branchRequestDto) {
        Branch branch = Branch.builder().branchName(branchRequestDto.getBranchName()).
                hodName(branchRequestDto.getHodName()).
                contactNo(branchRequestDto.getContactNo()).
                grant(branchRequestDto.getGrant()).build();

        return branch;
    }
}
