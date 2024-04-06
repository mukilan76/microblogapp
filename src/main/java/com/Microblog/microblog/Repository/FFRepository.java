package com.Microblog.microblog.Repository;

import com.Microblog.microblog.Entity.FollowersFollowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FFRepository extends JpaRepository<FollowersFollowing,Integer> {
    List<FollowersFollowing> findByFollowing(int following);

    // Method to find following by followers
    List<FollowersFollowing> findByFollowers(int followers);
    boolean existsByFollowingAndFollowers(int following, int follower);
    void deleteByFollowingAndFollowers(int following , int follower);
}
