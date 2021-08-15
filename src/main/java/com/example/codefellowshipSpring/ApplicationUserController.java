package com.example.codefellowshipSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationUserController {
@Autowired
UserDetailsServiceImplemnet userDetailsServiceImplemnet;
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup.html";
    }
    @GetMapping("/users/{id}")
    public String getUserProfile(@PathVariable int id, Model model) {
        //ApplicationUser userDetails = userDetailsServiceImplemnet.getUserById(id);
        //model.addAttribute("userDetails", userDetails);
        return ("");
    }
    @GetMapping("/login")
    public String getSignInPage(){
        return "signin.html";
    }

    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam(value="username") String username, @RequestParam(value="password") String password){
       // ApplicationUser newUser = new ApplicationUser(username,bCryptPasswordEncoder.encode(password));
       // applicationUserRepository.save(newUser);
        return new RedirectView("/login");
    }

}
