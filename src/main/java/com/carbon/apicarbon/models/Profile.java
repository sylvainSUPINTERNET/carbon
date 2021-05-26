package com.carbon.apicarbon.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "Profiles")
@Table(name = "profiles")
public class Profile implements Serializable {

    @Id 
    @GeneratedValue
    long id;

    @Column
    private Long carbong;

    @Column
    private Long level;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(updatable = true)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Profile(){}

    public Profile(Long carbong, Long level) {
        this.carbong = carbong;
        this.level = level;
    }

    public void setCarbong(Long carbong) {
        this.carbong = carbong;
    }

    public Long getCarbong(){
        return this.carbong;
    }

    public void setLevel(Long level) {
        this.level = level;
    }
    public Long getLevel(){
        return this.level;
    }
    
}
