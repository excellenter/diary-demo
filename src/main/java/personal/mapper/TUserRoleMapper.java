package personal.mapper;

import org.apache.ibatis.annotations.Param;
import personal.entity.TUserRole;

import java.util.List;
import java.util.Map;

public interface TUserRoleMapper extends TBaseMapper<TUserRole, Long> {

    List<Map<String, Object>> getRoleByUser(@Param("id") String id);

    Integer deleteByUserAndRole(Map<String, Object> map);

    Integer deleteByUser(@Param("id") String id);
}