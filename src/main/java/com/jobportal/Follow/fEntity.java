package com.jobportal.Follow;

import jakarta.persistence.*;

@Entity
@Table(name = "follow")
public class fEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long follower;
    private Long following;

    public fEntity() {
    }

    public Long getId() {
        return id;
    }

    public Long getFollower() {
        return follower;
    }

    public void setFollower(Long follower) {
        this.follower = follower;
    }

    public Long getFollowing() {
        return following;
    }

    public void setFollowing(Long following) {
        this.following = following;
    }
}