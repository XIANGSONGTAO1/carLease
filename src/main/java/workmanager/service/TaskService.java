package workmanager.service;

import workmanager.entity.Task;
import workmanager.util.MyResult;

public interface TaskService {
    public MyResult add(Task task);
    public MyResult list(Task task);
}
