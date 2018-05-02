package personal.mapper;

import org.apache.ibatis.annotations.Param;
import personal.entity.TUserGroup;

import java.util.List;
import java.util.Map;

public interface TUserGroupMapper extends TBaseMapper<TUserGroup, Long> {

    List<Map<String, Object>> getGroupByUser(@Param("id") String id);

    Integer deleteByUserAndGroup(Map<String, Object> map);

    Integer deleteByUser(@Param("id") String id);
}