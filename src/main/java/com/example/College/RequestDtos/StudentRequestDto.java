package com.example.College.RequestDtos;

import com.example.College.Enums.BranchName;
import jakarta.persistence.Column;
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
public class StudentRequestDto {
    private String name;

    @Column(name = "roll_no", unique = true, nullable = false)
    private int rollNo;
    @Enumerated(value = EnumType.STRING)
    private BranchName branchName;
    private int marks;

    private int branchId;
}
