package workmanager.dao;


import workmanager.entity.Group;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface GroupMapper extends Mapper<Group>{
    int deleteByPrimaryKey(Integer id);

    int insert(Group record);

    int insertSelective(Group record);

    Group selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}