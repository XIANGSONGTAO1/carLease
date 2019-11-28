package workmanager.service;

import workmanager.entity.User;
import workmanager.util.MyResult;

public interface UserService {
    MyResult login(User user);
    MyResult regist(User user);
}
