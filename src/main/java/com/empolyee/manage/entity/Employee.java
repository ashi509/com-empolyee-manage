package com.empolyee.manage.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "Employee name can not be Empty.")
    @Size(min=3,message = "Employee name must be have 3 character.")
    private String name;
    @NotEmpty(message = "Employee city can not be Empty.")
    @Size(min=3,message = "Employee city must be have 3 character.")
    private String city;

    @NotEmpty(message = "Employee contact can not be Empty.")
    @Size(min=10,message = "Employee contact must be have 10 character.")

    private String contact;

    @NotEmpty(message = "Employee Email can not be Empty.")
    @Size(min=3,message = "Employee name must be have 3 character.")
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

    private double salary;
    @OneToOne(cascade =CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="Employee_add")
    private Address address ;
    private Date createdDate;




}
