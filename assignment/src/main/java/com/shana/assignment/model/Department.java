package com.shana.assignment.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Department {

    @Id
    private Long dID;

    private String departmentName;


}

