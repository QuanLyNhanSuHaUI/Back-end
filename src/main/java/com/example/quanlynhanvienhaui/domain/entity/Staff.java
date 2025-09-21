package com.example.quanlynhanvienhaui.domain.entity;

import com.example.quanlynhanvienhaui.constant.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Table(name = "staffs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(insertable = false, updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "employee_code", nullable = false, unique = true, length = 10)
    private String employeeCode;

    private String fullName;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String position;

    @Column(name = "is_active")
    private boolean isActive;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDate createAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @OneToOne(mappedBy = "staff", fetch = FetchType.LAZY)
    private Account account;

}
