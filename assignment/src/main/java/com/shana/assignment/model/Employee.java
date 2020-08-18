package com.shana.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@ApiModel(description = "All details about the user")
@Table(name = "Employees")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ApiModelProperty(notes = "name of the entity")
    @Column(name = "title")
    private String title;


    @ApiModelProperty(notes = "description of the entity")
    @Size(min = 2, message = "name should be atleast 2 characters")
    @Column(name = "description")
    private String description;

    @ApiModelProperty(notes = "possible value true or false")
    @Column(name = "published")
    private boolean published;

 /*   @Column(name = "birthDate")
    @Past // Date of Birth cannnot be in future
    private Date birthDate;*/


    @OneToMany(targetEntity = Department.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cp_fk", referencedColumnName = "Id")
    private List<Department> departments;

}
