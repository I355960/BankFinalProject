package com.JavaProject.JavaProject.Repo;

import com.JavaProject.JavaProject.Entity.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface branchRepo extends CrudRepository<Branch,String> {
}
