package com.JavaProject.JavaProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Bank")
@AllArgsConstructor
@NoArgsConstructor

public class Bank {


    @Id
    @Column
    private String bankCode;

    @Column
    private String bankName;

    @Column
    private String address;

    @Column
    private Integer pinCode;

}
