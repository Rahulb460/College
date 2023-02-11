package com.example.College.Models;

import com.example.College.Enums.BranchName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int rollNo;
    @Enumerated(value = EnumType.STRING)
    private BranchName branchName;
    private int marks;

    @ManyToOne
    @JoinColumn
    private Branch branch;
}
