package workmanager.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import workmanager.service.FriendService;
import workmanager.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/FriendController")
public class FriendController {
    @Autowired
    private FriendService friendService;
    @ResponseBody
    @PostMapping("/selectFriendByUserId")
    public MyResult selectFriendByUserId(@RequestParam("addUserId") Integer addUserId){
        MyResult result = friendService.selectFriendByAddUserId(addUserId);
        return result;
    }
}
