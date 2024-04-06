package com.Microblog.microblog.Repository;

import com.Microblog.microblog.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
 Profile findByUserid(int userid);
}
