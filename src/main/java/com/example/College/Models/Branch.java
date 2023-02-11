package com.example.College.Models;

import com.example.College.Enums.BranchName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "branch")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hodName;
    @Enumerated(value = EnumType.STRING)
    private BranchName branchName;

    private String contactNo;

    private int grant;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Students> studentsList;
}
