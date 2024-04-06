package com.Microblog.microblog.Service;

import com.Microblog.microblog.DTO.TweetsAndPosts;
import com.Microblog.microblog.DTO.TweetsDTO;
import com.Microblog.microblog.Entity.*;
import com.Microblog.microblog.Repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TweetService {
    PostRepository por;
    FFRepository fr;
TweetRepository tr;
UserRepository ur;
ProfileRepository pr;

    public TweetService(TweetRepository tr , UserRepository  ur,ProfileRepository pr, FFRepository fr , PostRepository por) {
        this.pr=pr;
        this.tr = tr;
        this.ur=ur;
        this.fr=fr;
        this.por=por;
    }

    public PostRepository getPor() {
        return por;
    }

    public void setPor(PostRepository por) {
        this.por = por;
    }

    public FFRepository getFr() {
        return fr;
    }

    public void setFr(FFRepository fr) {
        this.fr = fr;
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

    public TweetRepository getTr() {
        return tr;
    }

    public void setTr(TweetRepository tr) {
        this.tr = tr;
    }
    public List<Tweet> findByUserid(int userid){

        return tr.findByUserid(userid);
    }
public List<TweetsAndPosts> getTweetsPostsOfFollowing(List<FollowersFollowing> ff){
      List<TweetsAndPosts> listoftweetsandposts = new ArrayList<>();

    for (FollowersFollowing f : ff) {
        User user =ur.findById(f.getFollowing()).orElseThrow(() -> new IllegalArgumentException("User not found"));
   //     Profile profile= pr.findById(f.getFollowing()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<Tweet> content =tr.findByUserid(user.getId());
        List<Post> post = por.findByUserid(user.getId());
        for(Tweet c: content){

       //     TweetsDTO t =new TweetsDTO(user.getName(), c.getContent(), profile.getProfile());
            TweetsAndPosts t =new TweetsAndPosts(user.getId(),user.getName(), c.getId(),c.getContent(),c.getPostingTimetweet());
            listoftweetsandposts.add(t);
        }
        for(Post po:post){
            TweetsAndPosts p = new TweetsAndPosts(user.getId(),user.getName(),po.getId(),po.getPost(),po.getCaption(),po.getPostingTimepost());
            listoftweetsandposts.add(p);
        }

      }
    Collections.sort(listoftweetsandposts, (t1, t2) -> t2.getPostingTime().compareTo(t1.getPostingTime()));

    return listoftweetsandposts;

    }


public boolean posttweet(int userid , String content, LocalDateTime localDateTimetweet){
       tr.save(new Tweet(userid,content,localDateTimetweet));
return true;
}

public List<Tweet> getmytweets(int userid){
       /*** System.out.println("----------------------------------------------------////////////////////////"+userid);
        List<Tweet> t=tr.findByUserid(userid);
        for(Tweet ti:t){
            System.out.println(ti.getContent());
        }**/
        return tr.findByUserid(userid);

}
public List<Post> getmyposts(int userid){
        return por.findByUserid(userid);
}
public void postmypost(Post post){
por.save(post);

}
public Post getpost(int id){
    Optional<Post> optionalPost = por.findById(id);
    return optionalPost.orElse(null);
}
}
//public List<Tweet> getalltweets(int )
//}
