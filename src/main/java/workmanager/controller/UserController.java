package workmanager.controller;

import workmanager.entity.User;
import workmanager.service.UserService;
import workmanager.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;
    @ResponseBody
    @PostMapping("/login")
    public MyResult login(@RequestBody User user){
        return userService.login(user);
    }
    @ResponseBody
    @PostMapping("/regist")
    public MyResult regist(@RequestBody User user){
        return userService.regist(user);
    }
}
