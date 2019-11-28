package workmanager.controller;

import workmanager.entity.Group;
import workmanager.service.GroupService;
import workmanager.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/groupController")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @PostMapping("/add")
    public MyResult add(@RequestBody Group group){
        return groupService.add(group);
    }
}
