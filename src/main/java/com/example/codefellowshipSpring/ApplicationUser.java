package com.example.codefellowshipSpring;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    @Column(unique = true)
    String username;
    String password;
    String firstname;
    String lastname;
    Integer dateofbirth;
    String bio;
    public ApplicationUser(String username, String password, String firstname, String lastname, Integer dateofbirth,String bio) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.bio = bio;

    }

    public ApplicationUser(){}

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setFirstName(String firstname){
        this.firstname = firstname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public void setDateOfBirth(Integer dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    public Integer getId() {
        return id;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
//
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import javax.xml.crypto.Data;
//import java.util.Collection;
//
//@Entity
//public class ApplicationUser implements UserDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public Integer getId() {
//        return id;
//    }
//      Integer id;
//    @Column(unique = true)
//    private String username;
//
//    private String password;
//    private String firstname;
//    private String lastname;
//    private String dateofbirth;
//    private String   bio;
//
//    public ApplicationUser(String username, String password, String firstname, String lastname, String dateofbirth, String bio) {
//        this.username = username;
//        this.password = password;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.dateofbirth = dateofbirth;
//        this.bio = bio;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getBio() {
//        return bio;
//    }
//
//    public void setBio(String bio) {
//        this.bio = bio;
//    }
//
//
//
//    public ApplicationUser() {
//        //Default Cons
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
