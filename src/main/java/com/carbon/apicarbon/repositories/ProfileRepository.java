package com.carbon.apicarbon.repositories;

import java.util.Collection;

import com.carbon.apicarbon.models.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query(
        value = "SELECT * FROM profiles ORDER BY random() LIMIT 200",
        nativeQuery = true
    )
    Collection<Profile> findRandomProfiles();
    
}
