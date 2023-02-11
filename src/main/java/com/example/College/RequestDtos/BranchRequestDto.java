package com.example.College.RequestDtos;

import com.example.College.Enums.BranchName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchRequestDto {
    private String hodName;
    @Enumerated(value = EnumType.STRING)
    private BranchName branchName;
    private String contactNo;

    private int grant;
}
