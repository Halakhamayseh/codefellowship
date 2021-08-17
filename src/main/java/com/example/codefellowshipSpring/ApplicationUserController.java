package com.example.codefellowshipSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
public class ApplicationUserController {
@Autowired
UserDetailsServiceImpl userDetailsServiceImplemnet;
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
   PostRepository postRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
//    public Principal p;
//    public Model model;

//    public Model getName(Principal p, Model model){
//
//        return model.addAttribute("usernamePrincipal",p.getName());
//    }
    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup.html";
    }

    @GetMapping("/login")
    public String getSignInPage(){
        return "signin.html";
    }

    @GetMapping("/")
    public String getHomePage(Principal p, Model model){
        if(p==null){
            return "error.html";
        }
        else {
            model.addAttribute("usernamePrincipal", p.getName());
            return "home.html";
        }
    }

    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam(value="username") String username, @RequestParam(value="password") String password, @RequestParam(value = "firstname")String firstname, @RequestParam(value = "lastname")String lastname, @RequestParam(value = "dateofbirth") String dateofbirth, @RequestParam(value = "bio")String bio){
        ApplicationUser newUser = new ApplicationUser(username,bCryptPasswordEncoder.encode(password),firstname,lastname,dateofbirth,bio);
        applicationUserRepository.save(newUser);
        return new RedirectView("/login");

    }
    @GetMapping("/user/{id}")
    public String getUser(Principal p, Model model, @PathVariable Integer id){
        model.addAttribute("usernamePrincipal",p.getName());
        model.addAttribute("userInformationGetById",applicationUserRepository.findById(id).get());
        return "userSpecific.html";
    }
    @GetMapping("/profile")
    public String getprofile(Principal p, Model model){
        model.addAttribute("usernamePrincipal",p.getName());
        model.addAttribute("profile",applicationUserRepository.findByUsername(p.getName()));
        return "profile.html";
    }
    @PostMapping("/profile")
    public RedirectView postprofile(Principal p, @RequestParam String body){
        Post newpost= new Post(body,applicationUserRepository.findByUsername(p.getName()));
        postRepository.save(newpost);
        return new RedirectView("/profile");
    }
    @PostMapping ("/follow/{id}")
    public RedirectView getfollow(Principal p,@PathVariable Integer id) {
        ApplicationUser applicationUserwhoisfollowMe = applicationUserRepository.findByUsername(p.getName());
        ApplicationUser applicationUserwhoisfollowFollowed = applicationUserRepository.findById(id).get();
        applicationUserwhoisfollowMe.getFollowers().add(applicationUserwhoisfollowFollowed);
       applicationUserwhoisfollowFollowed.getFollowing().add(applicationUserwhoisfollowMe);
        applicationUserRepository.save(applicationUserwhoisfollowMe);
        applicationUserRepository.save(applicationUserwhoisfollowFollowed);

        return new RedirectView("/feed");
    }
    @GetMapping("/feed")
    public String getAllFeed(Principal p, Model model){
        model.addAttribute("usernamePrincipal",p.getName());
        ApplicationUser applicationUserwhoisfollowMe=applicationUserRepository.findByUsername(p.getName());
        List<ApplicationUser>following=applicationUserwhoisfollowMe.getFollowers();
        model.addAttribute("feeds",following);
        return "feed.html";
    }
}
