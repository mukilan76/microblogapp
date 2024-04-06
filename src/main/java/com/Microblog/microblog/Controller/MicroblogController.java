
package com.Microblog.microblog.Controller;

import com.Microblog.microblog.DTO.UserDTO;
import com.Microblog.microblog.DTO.alluserDTO;
import com.Microblog.microblog.DTO.medto;
import com.Microblog.microblog.Entity.Post;
import com.Microblog.microblog.Entity.Profile;
import com.Microblog.microblog.Entity.Tweet;
import com.Microblog.microblog.Entity.User;
import com.Microblog.microblog.Repository.ProfileRepository;
import com.Microblog.microblog.Service.TweetService;
import com.Microblog.microblog.Service.UserService;
import com.Microblog.microblog.utils.ImageUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// muki------------------------------------------------------------------------

@Controller
public class MicroblogController {

    UserService us;
    TweetService ts;

    public MicroblogController( UserService us , TweetService ts) {
        this.ts = ts;
        this.us = us;
    }

    public UserService getUs() {
        return us;
    }

    public void setUs(UserService us) {
        this.us = us;
    }

    @GetMapping("/") public String loginpage(){return "LoginPage";}
    @GetMapping("/signuppage") public String signuppage(){return "SignupPage";}


    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, @RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "please select a file";
        }

        try {

            byte[] bytes = file.getBytes();
            Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

          us.saveprofile(blob,  us.saveuser(user).getId());





            return "redirect:/";
        } catch (IOException | SQLException e) {
            return "Error uploading file: " + e.getMessage();
        }}



    @GetMapping("/index") public String index(Model model,HttpSession session){
        if(session.getAttribute("userId")!=null){
        int userid =(int)session.getAttribute("userId");
      User user=us.finduser(userid);
      model.addAttribute("myfollowers",us.myfollowers(userid));
      model.addAttribute("myfollowing",us.myfollowing(userid));
//int followerscount = us.myfollowers(userid).size()-1;
//int followingcount = us.myfollowing(userid).size()-1;
//session.setAttribute("medto",new medto(user.getName(),followerscount,followingcount,user.getBio(),user.getUsername()));
        model.addAttribute("tweetsandposts",  ts.getTweetsPostsOfFollowing(us.findfollowing(userid)));}

else{
    return "redirect:/";
        }

        return "Index";

    }

    @PostMapping("/login") public String login(@ModelAttribute UserDTO userDTO , HttpSession session){
        if(us.CheckifUserPresent(userDTO)){
               session.setAttribute("userId",us.CurrentUserid(userDTO));
               session.setAttribute("name",us.currentusersname(userDTO));

            return "redirect:/index";}

        else return "redirect:/";
        }
@GetMapping("/tweets")
    public String tweets(){

     // ts.getTweetsOfFollowing(us.findfollowing());
        return "redirect:/Index";
}
@GetMapping("/logout")
public String logout(HttpSession session){
session.invalidate();
return "redirect:/";
}


@PostMapping("/posttweet")
public String posttweet(@RequestParam("tweetContent") String tweetContent , HttpSession session){
ts.posttweet((int)session.getAttribute("userId"),tweetContent, LocalDateTime.now());
return "redirect:/index";
}



@GetMapping("/users")
public String users(HttpSession session,Model model){
        List<alluserDTO> allusers=new ArrayList<>();
        List<User>s= us.getallusers();
        for(User a: s){
            if(a.getId()!=(int)session.getAttribute("userId")){
                alluserDTO alluserdto= new alluserDTO(a.getId() , a.getName() , us.findfollowedornot((int)session.getAttribute("userId"),a.getId()));
               // System.out.println(alluserdto.getId()+alluserdto.getName());
                allusers.add(alluserdto);
            }}

        model.addAttribute("allusers",allusers);

        return"Users";
}
@GetMapping("/follow")
    public String followunfollow(HttpSession session, @RequestParam("id") int userId,@RequestParam("followed") boolean followed ){

      if(followed){
          us.removingfollowing(userId,(int)session.getAttribute("userId"));


      }
      else{
          us.savefollowing(userId,(int)session.getAttribute("userId"));
      }
session.removeAttribute("searchedusers");
return "redirect:/index";
}
    @GetMapping("/display")
    public ResponseEntity<byte[]> displayImage(@RequestParam("id") int userid) throws IOException, SQLException
    {
        System.out.println("---------------------/////////////////////////uuuuuusssssseeerrrriddddd"+userid);
      Blob profile=  us.getprofile(userid);
        byte [] imageBytes = null;
        imageBytes = profile.getBytes(1,(int) profile.length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
    @GetMapping("/me")
    public String me(HttpSession session, Model model){


model.addAttribute("mytweets",ts.getmytweets((int)session.getAttribute("userId")));
model.addAttribute("myposts",ts.getmyposts((int)session.getAttribute("userId")));


        return "me";
    }
    @PostMapping("/addpost")
    public String addpost(@RequestParam("file") MultipartFile file , @RequestParam("caption") String caption, HttpSession session){
        try {

            byte[] bytes = file.getBytes();
            Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
          ts.postmypost(new Post((int)session.getAttribute("userId"),blob,caption,LocalDateTime.now()));





        } catch (IOException | SQLException e) {

        }
        return "redirect:/index";

    }
    @GetMapping("/displaypost")
    public ResponseEntity<byte[]> displayPost(@RequestParam("id") int postid) throws IOException, SQLException
    {
        Blob post=  ts.getpost(postid).getPost();
        byte [] imageBytes = null;
        imageBytes = post.getBytes(1,(int) post.length());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
    //@GetMapping("/deletepost")
    //public String


    @GetMapping("/search")
    public String searchUsers(@RequestParam("search") String searchTerm, HttpSession session , Model model) {
        List<alluserDTO> searchedusers=new ArrayList<>();
        List<User> searchResults = us.searchUsers(searchTerm);

        for(User a: searchResults){
            if(a.getId()!=(int)session.getAttribute("userId")){
                alluserDTO alluserdto= new alluserDTO(a.getId() , a.getName() , us.findfollowedornot((int)session.getAttribute("userId"),a.getId()));
                searchedusers.add(alluserdto);
            }}
        System.out.println("----------------------------------------------");
        searchedusers.forEach(n->System.out.println(n.getName()));
      // model.addAttribute("searchedusers", searchedusers);
        session.setAttribute("searchedusers",searchedusers);

//model.addAttribute("searchedusers",searchedusers);
        return "redirect:/Indexpopup";
    }
@GetMapping("/searchusers")
    public String searchusers(){

         return"searchusers";
}
@GetMapping("/following")
    public String following(HttpSession session , Model model){
        model.addAttribute("followings",us.myfollowing((int)session.getAttribute("userId")));

        return "following";
}
@GetMapping("/Indexpopup")
    public String Indexpopup(HttpSession session,Model model){
    if(session.getAttribute("userId")!=null){
        int userid =(int)session.getAttribute("userId");

        model.addAttribute("tweetsandposts",  ts.getTweetsPostsOfFollowing(us.findfollowing(userid)));}
    else{
        return "redirect:/";
    }


    return "Indexpopup";

}
@GetMapping("/closepopup")
    public String closepopup(HttpSession session){
        session.removeAttribute("searchedusers");
        return "redirect:/index";
}


}
