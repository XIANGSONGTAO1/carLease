package workmanager.service.imp;

import workmanager.dao.GroupMapper;
import workmanager.entity.Group;
import workmanager.service.GroupService;
import workmanager.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Override
    public MyResult add(Group group) {
        MyResult myResult = new MyResult();
        int num = groupMapper.insertSelective(group);
        if (num<=0){
            myResult.setCode(300);
            myResult.setMessage("插入失败");
            myResult.setObj(group);
        }else{
            myResult.setMessage("插入成功");
            myResult.setObj(group);
            myResult.setCode(200);
        }
        return myResult;
    }
}
