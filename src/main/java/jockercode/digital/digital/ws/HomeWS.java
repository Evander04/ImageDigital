package jockercode.digital.digital.ws;

import jockercode.digital.digital.controller.UserController;
import jockercode.digital.digital.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class HomeWS {
    @Autowired
    private UserController userController;

    @RequestMapping(value = "/home")
    public String home(Model model){
        return "home";
    }

    @PostMapping(path = "/test")
    @ResponseBody
    public Users test(@RequestBody HashMap<String, String> body) {


        System.out.println(body.toString());
        Users users= new Users(body.get("username"),body.get("pass"));
        users.setRole(new ArrayList<String>(){
            {add("ROOT");}
        });
        return userController.save(users);

    }
}
