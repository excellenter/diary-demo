package personal.service;

import personal.entity.TUserGroup;
import java.util.List;
import java.util.Map;

public interface UserGroupService extends BaseService<TUserGroup, Long> {

    List<Map<String, Object>> getGroupByUser(String userId);

    Map<String, Object> deleteByUser(String userId);

    Map<String, Object> deleteByUserAndGroup(TUserGroup userGroup);
}
