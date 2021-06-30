package com.JavaProject.JavaProject.Repo;

import com.JavaProject.JavaProject.Entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface bankRepo extends CrudRepository<Bank,String> {
}
