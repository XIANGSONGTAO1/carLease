package workmanager.service.imp;

import workmanager.dao.FriendMapper;
import workmanager.dao.TaskMapper;
import workmanager.service.FriendService;
import workmanager.util.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workmanager.util.ValidatorUtil;

import java.util.List;
import java.util.Map;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public MyResult selectFriendByAddUserId(Integer addUserId) {
        MyResult myResult = new MyResult();
        List<Map<String, Object>> list = friendMapper.selectFriendByAddUserId(addUserId);
        if (ValidatorUtil.isNotNullOrEmpty(list)) {
            myResult.setCode(200);
            myResult.setList(list);
            myResult.setMessage("查询成功");
        }
        return myResult;
    }
}
