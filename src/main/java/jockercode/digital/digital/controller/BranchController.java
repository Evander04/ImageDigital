package jockercode.digital.digital.controller;

import jockercode.digital.digital.pojo.Branch;
import jockercode.digital.digital.pojo.UserBranch;
import jockercode.digital.digital.pojo.Users;
import jockercode.digital.digital.repository.BranchRepository;
import jockercode.digital.digital.repository.UserBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchController {

    @Autowired
    private BranchRepository bRepo;

    @Autowired
    private UserBranchRepository ubRepo;

    public Branch save(Branch branch){
        return bRepo.save(branch);
    }

    public void saveUser(Branch branch, Users user){
        ubRepo.save(new UserBranch(branch,user));
    }

    public List<Branch> findAll(){
        List<Branch> list=new ArrayList<>();
        bRepo.findAll().forEach(b->{
            list.add(b);
        });
        return list;
    }
}
