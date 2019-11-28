package workmanager.dao;

import org.springframework.stereotype.Repository;
import workmanager.entity.Task;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface TaskMapper extends Mapper<Task> {
    int deleteByPrimaryKey(Integer id);

    int insert(Task record);
    int test();

    int insertSelective(Task record);

    Task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);
}