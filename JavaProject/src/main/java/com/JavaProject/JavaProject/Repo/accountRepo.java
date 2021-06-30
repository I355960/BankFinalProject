package com.JavaProject.JavaProject.Repo;

import com.JavaProject.JavaProject.Entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface accountRepo extends CrudRepository<Account,String> {
}
