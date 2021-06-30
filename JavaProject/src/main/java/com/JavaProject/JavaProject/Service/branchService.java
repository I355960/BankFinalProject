package com.JavaProject.JavaProject.Service;

import com.JavaProject.JavaProject.Entity.Branch;
import com.JavaProject.JavaProject.Repo.branchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class branchService {

    @Autowired
    private branchRepo branchrepo;

    public Branch createBranch(String ifsc_code, String branchName, String Address, Integer pincode)
    {
        Branch branch = new Branch();
        branch.setIfscCode(ifsc_code);
        branch.setBranchName(branchName);
        branch.setAddress(Address);
        branch.setPinCode(pincode);
        return branchrepo.save(branch);
    }

    public List<Branch> getAllBranch()
    {
        List<Branch> branch = new ArrayList<Branch>();
        branchrepo.findAll().forEach(branch1 -> branch.add(branch1));
        return branch;
    }

    //getting a specific record
    public Branch getBranchById(String id)
    {
        return branchrepo.findById(id).get();
    }

    public void recordUpdate(Branch branch)
    {
        branchrepo.save(branch);
    }
    //deleting a specific record
    public void deleteRecord(String id)
    {
        branchrepo.deleteById(id);
    }
}
