package com.Microblog.microblog.Repository;

import com.Microblog.microblog.Entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository  extends JpaRepository<Tweet,Integer> {
    List<Tweet> findByUserid(int userid);

}
