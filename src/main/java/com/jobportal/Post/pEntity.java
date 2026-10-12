package com.jobportal.Post;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;



@Entity 
@Table(name ="Post") 
public class pEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "UserId is required")
    @Column(nullable = false)
   private Long userId;
    private String imgUrl;

    @Size(max=700) 
    private String discription;
    private String tittle;



    //get/set
//id
    public Long getId(){
       return id;
    }
    public void setId(Long id){
        this.id = id;
    }


 //UserId
 public Long getUserId(){
    return userId;
 }  
 public void setUserId(Long UserId){
    this.userId = UserId;
 }  
    

 //imgUrl
 public String getImgUrl() {
    return imgUrl;
}
public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
}

//discription
public String getDiscription() {
    return discription;
}
public void setDiscription(String discription) {
    this.discription = discription;
}

//tittle
public String getTittle() {
    return tittle;
}

public void setTittle(String tittle) {
    this.tittle = tittle;
}
}
