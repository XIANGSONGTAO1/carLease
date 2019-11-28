package workmanager.dao;

import workmanager.entity.Friend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
@Repository
public interface FriendMapper extends Mapper<Friend>{
    List<Map<String,Object>> selectFriendByAddUserId(@Param("addUserId") Integer addUserId);
}
