package com.jobportal.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size; 
@Entity 
@Table(name ="Users")

public class UserEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique =true , nullable =false)
    private String email;
    @Size (min=6 , max=12)
    private String password;
    @Size(min =10 , max=12)
    private String phona;
    private String role;
    private String location;
    @Column(length=500)
    private String about;
    private String education;
    @Column(length=200)
    private String experience;
    @Column(length=150)
    private String skills;
    @ElementCollection

    //getter and setter

    //Id method
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id =id;
    }

    //name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    //email
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
  //pass
  public String getPassword(){
    return password;
  }
  public void setPassword(String password){
    this.password = password;
  }

    
  //phona
  public String getPhona(){
    return phona;
  }
  public void setPhona(String phona){
    this.phona = phona;
  }

  //role
  public String getRole(){
    return role;
  }
  public void setRole(String role){
    this.role = role;
  }

  //location
  public String getLocation(){
    return location;
  }
  public void setLocation(String location){
    this.location =location;
  }

   //about
  public String getAbout(){
    return about;
  }
  public void setAbout(String about){
    this.about =about;
  }

  //education   
  public String getEducation(){
    return education;
  }
  public void setEducation(String education){
    this.education =education;
  }

  //expricnec
  public String getExperience(){
    return experience;
  }
  public void setExperience(String experience){
    this.experience = experience;

  }
  //skills
  public String getSkills(){
    return skills;
  }
  public void setSkills(String skills){
    this.skills = skills;
  }

}
