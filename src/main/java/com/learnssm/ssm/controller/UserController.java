package com.learnssm.ssm.controller;

import com.learnssm.ssm.po.User;
import com.learnssm.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
/*import javax.servlet.http.HttpSession;*/
import java.util.List;

@Controller
public class UserController {

    @Resource(name = "userSericerImpl")
    private UserService userService;

   /* @RequestMapping("/Userlogin")
    public String login(User user, HttpSession session){
        List<User> u = userService.getUser(user);
        if(u != null && u.size()>0){
            User user1 = u.get(0);
            session.setAttribute("User",user1);
            return "redirect:/itemList.action";
        }
        return "redirect:/login";
    }*/
    @RequestMapping("/showlogin")
    public String showLogin(){
        return "login";
    }

}
