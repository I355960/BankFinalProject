package com.JavaProject.JavaProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity

@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    @Id
    @Column
    private String customerId;

    @Column
    private  String panCard;

    @Column
    private String customerName;

    @Column
    private String email;

    @Column
    private String customerAddress;

    @Column
    private Integer customerPinCode;



}
