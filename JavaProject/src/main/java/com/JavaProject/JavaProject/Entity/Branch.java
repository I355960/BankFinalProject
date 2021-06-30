package com.JavaProject.JavaProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Branch {

    @Id
    @Column
    private String ifscCode;

    @Column
    private String branchName;

    @Column
    private String address;

    @Column
    private Integer pinCode;


}
