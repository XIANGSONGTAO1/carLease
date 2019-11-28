package workmanager.service.imp;

import workmanager.dao.TaskMapper;
import workmanager.entity.Task;
import workmanager.service.TaskService;
import workmanager.util.MyResult;
import workmanager.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public MyResult add(Task task) {
        MyResult myResult = new MyResult();
        int num = taskMapper.insertSelective(task);
        if (num<=0){
            myResult.setMessage("添加失败");
        }else{
            myResult.setMessage("添加成功");
            myResult.setCode(200);
            myResult.setObj(task);
        }
        return myResult;
    }

    @Override
    public MyResult list(Task task) {
        MyResult myResult = new MyResult();
        List<Task> taskList = taskMapper.select(task);
        if (ValidatorUtil.isNullOrEmpty(taskList)){
            myResult.setMessage("没有任务");
            myResult.setCode(300);
        }else{
            myResult.setMessage("查询成功");
            myResult.setCode(200);
            myResult.setList(taskList);
        }
        return myResult;
    }
}
