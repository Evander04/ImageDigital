package jockercode.digital.digital.ws;

import jockercode.digital.digital.controller.BranchController;
import jockercode.digital.digital.pojo.Branch;
import jockercode.digital.digital.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/branch")
public class BranchWS {

    @Autowired
    private BranchController bController;

    @GetMapping
    public String branch(Model model, HttpServletRequest request){
        Users user= (Users) request.getAttribute("userObject");

        List<Branch> branches= bController.findAll();
        model.addAttribute("lsBranch",branches);
        return "branch";
    }
    @ResponseBody
    @PostMapping("/save")
    public Branch save(HttpServletRequest request, @RequestBody Branch body){
        body=bController.save(body);
        System.out.println(body);
        return body;
    }
}
