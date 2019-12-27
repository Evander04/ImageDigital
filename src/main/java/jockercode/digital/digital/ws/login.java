package jockercode.digital.digital.ws;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class login {
    @RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
    public String login(Authentication auth)
    {
        //if is logged in, redirect to home
        if (auth != null && auth.isAuthenticated())
            return "redirect:/home";

        //otherwise ask to login
        return "login";
    }

    //Defining logout path
    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout(Authentication auth)
    {
        return "redirect:/logout";
    }
}
