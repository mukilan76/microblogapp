package com.Microblog.microblog.Repository;

import com.Microblog.microblog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    boolean existsByUsernameAndPassword(String username, String password);
    User findByUsernameAndPassword(String username, String password);
     List<User> findByNameContainingIgnoreCase(String searchTerm);
}
