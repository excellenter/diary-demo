package personal.service;

import personal.entity.TUserRole;

import java.util.List;
import java.util.Map;

public interface UserRoleService extends BaseService<TUserRole, Long> {

    List<Map<String, Object>> getRoleByUser(String userId);

    Map<String, Object> deleteByUser(String userId);

    Map<String, Object> deleteNyUserAndRole(TUserRole userRole);
}
