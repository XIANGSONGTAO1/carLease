package workmanager.service.imp;

import workmanager.dao.UserDao;
import workmanager.entity.User;
import workmanager.service.UserService;
import workmanager.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workmanager.util.ValidatorUtil;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public MyResult login(User user) {
        MyResult myResult = new MyResult();
            List<User> userList = userDao.select(user);
        if (userList.size()!=0){
            myResult.setCode(200);
            myResult.setMessage("登录成功");
            myResult.setList(userList);
            myResult.setObj(userList.get(0));
        }else{
            myResult.setCode(-200);
            myResult.setMessage("登录失败");
        }
        return myResult;
    }

    @Override
    public MyResult regist(User user) {
        MyResult myResult = new MyResult();
        if (ValidatorUtil.isNullOrEmpty(user.getUsername())||ValidatorUtil.isNullOrEmpty(user.getPassword())){
            myResult.setMessage("注册失败");
            myResult.setCode(300);
            return myResult;
        }
        Integer count = userDao.insert(user);
        if (count==null||count==0){
            myResult.setMessage("注册失败");
            myResult.setCode(300);

        }else{
            myResult.setCode(200);
            myResult.setMessage("注册成功");
        }
        return myResult;
    }
}
