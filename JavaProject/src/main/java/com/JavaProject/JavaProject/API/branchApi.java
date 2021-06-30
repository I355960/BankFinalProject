package com.JavaProject.JavaProject.API;


import com.JavaProject.JavaProject.Entity.Bank;
import com.JavaProject.JavaProject.Entity.Branch;
import com.JavaProject.JavaProject.Repo.branchRepo;
import com.JavaProject.JavaProject.Service.branchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class branchApi {

    @Autowired
    private branchService branchservice;
    private branchRepo branchrepo;

    @PostMapping("/branch")
    public Branch createBank(@RequestBody Branch branch)
    {
        return branchservice.createBranch(branch.getIfscCode(),branch.getBranchName(),branch.getAddress(),branch.getPinCode());
    }

    @GetMapping("/branch")
    private List<Branch> getAllBranch()
    {
        return branchservice.getAllBranch();
    }

    @GetMapping("/branch/{id}")
    private Branch getBranch(@PathVariable("id") String id)
    {
        return branchservice.getBranchById(id);
    }


    @DeleteMapping("/branch/{id}")
    private void deleteBranch(@PathVariable("id") String id)
    {
        branchservice.deleteRecord(id);
    }


    //update Bank detail in the database
    @PostMapping("/branchupdate")
    private String updateBranch(@RequestBody Branch branch)
    {
        branchservice.recordUpdate(branch);
        return branch.getIfscCode();
    }
}
