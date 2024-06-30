package com.devali.Spring_boot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message="Please Add Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    public Department(String departmentAddress, String departmentCode, Long departmentId, String departmentName) {
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    
    


    

    



}
