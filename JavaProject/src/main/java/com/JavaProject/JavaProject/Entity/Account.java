package com.JavaProject.JavaProject.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor


@Entity
@Configuration
public class Account {

    @Id
    @Column
    private String accountNumber;

    @Column
    private String accountType;

    @Column
    private LocalDate  accountOpenDate =  LocalDate.now();;

    @Column
    private double totalBalance;

}
