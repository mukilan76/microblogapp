package com.Microblog.microblog.Service;

import com.Microblog.microblog.DTO.UserDTO;
import com.Microblog.microblog.DTO.alluserDTO;
import com.Microblog.microblog.Entity.FollowersFollowing;
import com.Microblog.microblog.Entity.Profile;
import com.Microblog.microblog.Entity.User;
import com.Microblog.microblog.Repository.FFRepository;
import com.Microblog.microblog.Repository.ProfileRepository;
import com.Microblog.microblog.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    FFRepository fr;

    UserRepository ur;
    ProfileRepository pr;


    public UserService(FFRepository fr, UserRepository ur, ProfileRepository pr) {
        this.fr = fr;
        this.ur = ur;
        this.pr = pr;
    }




    public ProfileRepository getPr() {
        return pr;
    }

    public void setPr(ProfileRepository pr) {
        this.pr = pr;
    }



    public UserRepository getUr() {
        return ur;
    }

    public void setUr(UserRepository ur) {
        this.ur = ur;
    }

    public User saveuser(User user){
return ur.save(user);

    }
    public Boolean CheckifUserPresent(UserDTO userDTO){

        return ur.existsByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
    }
public void saveprofile(Blob profile , int userid){
pr.save(new Profile(userid,profile) );

}
public void savefollowing(int  followingid ,int followerid ){
fr.save(new FollowersFollowing(followingid , followerid));

}
public List<FollowersFollowing> findfollowing(int id){

        return fr.findByFollowers(id);
}
public List<FollowersFollowing> findfollowers(int id){

       return fr.findByFollowing(id);
}
public int CurrentUserid(UserDTO userDTO){

     return ur.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword()).getId();
}
public String currentusersname(UserDTO userDTO){

        return ur.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword()).getName();

}public List<User> getallusers(){
       return ur.findAll();
}
    public boolean findfollowedornot(int userId , int followingid){

        return fr.existsByFollowingAndFollowers(followingid,userId);
    }
    @Transactional
  public void  removingfollowing(int followingid, int followerid){
        fr.deleteByFollowingAndFollowers(followingid,followerid);

  }
  public Blob getprofile(int userid){
    Profile profile=  pr.findByUserid(userid);
    if(profile ==null){
        return null;

    }
    else
      return profile.getProfile();

  }
   public List<User> searchUsers(String searchterm){

       return ur.findByNameContainingIgnoreCase(searchterm);
    }
public List<alluserDTO> myfollowing(int id){
        List<alluserDTO> followings = new ArrayList<>();
       List<FollowersFollowing> findfollowings= fr.findByFollowers(id);
       for(FollowersFollowing f:findfollowings){
        Optional<User> optionaluser=   ur.findById(f.getFollowing());
       User user =optionaluser.orElse(null);
       alluserDTO following= new alluserDTO(user.getId(),user.getName(),true);
           followings.add(following);
       }
       return followings;

}
public List<alluserDTO> myfollowers(int id){
        List<alluserDTO> followers=new ArrayList<>();
    List<FollowersFollowing> findfollowers=   fr.findByFollowing(id);
    for(FollowersFollowing f:findfollowers){
        Optional<User> optionaluser=   ur.findById(f.getFollowers());
        User user = optionaluser.orElse(null);
        alluserDTO follower =new alluserDTO(user.getId(), user.getName(),findfollowedornot(id, user.getId()));
        followers.add(follower);
    }
    return followers;
}
public User finduser(int id){

      return  ur.findById(id).orElse(null);
}

}
