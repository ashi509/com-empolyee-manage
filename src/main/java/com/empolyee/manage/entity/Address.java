package com.empolyee.manage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "Employee state can't be empty.")
    @Size(min=3,max = 100,message = "Employee state must be have in 3 character.")
    private String state;
    @NotEmpty(message = "Employee country can't be empty.")
    @Size(min = 3,message = "country must be have 3 character.")
    private String country;


}
