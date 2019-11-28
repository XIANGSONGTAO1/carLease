package workmanager.controller;

import workmanager.entity.Task;
import workmanager.service.TaskService;
import workmanager.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/taskController")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @ResponseBody
    @PostMapping("/add")
    public MyResult add(@RequestBody Task task){
        return taskService.add(task);
    }
    @ResponseBody
    @PostMapping("/list")
    public MyResult list(@RequestBody Task task){
        return taskService.list(task);
    }
}
