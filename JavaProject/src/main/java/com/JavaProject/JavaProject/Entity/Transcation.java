package com.JavaProject.JavaProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@Entity
public class Transcation {

    @Column
    @Id
    private String transId = UUID.randomUUID().toString();
    @Column
    private LocalDate transDate = LocalDate.now();
    @Column
    private String accountNumber;
    @Column
    private double creditBalance;
    @Column
    private double debitBalance;
    @Column
    private double totalAmount;
    @Column
    private String remarks;
}
