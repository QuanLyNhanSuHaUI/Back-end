package com.example.quanlynhansu.domain.entity;

import com.example.quanlynhansu.constant.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "employees")
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(insertable = false, updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "employee_code", length = 10, unique = true)
    private String employeeCode;

    @Column(name = "full_name")
    private String fullName;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String position;

    private String qualification;


    @Column(name = "is_active")
    private Boolean isActive;

    @CreatedDate
    @Column(name = "create_at")
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonIgnore
    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Account account;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Payroll> payrolls;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Contract> contracts;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<LeaveRequest> leaveRequests;
}
