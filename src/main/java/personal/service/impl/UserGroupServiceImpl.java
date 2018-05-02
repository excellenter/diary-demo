package personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.entity.TUserGroup;
import personal.mapper.TUserGroupMapper;
import personal.service.UserGroupService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserGroupServiceImpl extends BaseServiceImpl<TUserGroup, Long> implements UserGroupService {

    @Autowired
    private TUserGroupMapper userGroupMapper;

    @Override
    public List<Map<String, Object>> getGroupByUser(String userId) {
        return userGroupMapper.getGroupByUser(userId);
    }

    @Override
    public Map<String, Object> deleteByUser(String userId) {
        Map<String, Object> map = new HashMap<>(4);
        if (userGroupMapper.deleteByUser(userId) > 0) {
            map.put("code", 200);
        } else {
            map.put("code", 216);
            map.put("message", "删除失败,请检查用户id是否正确");
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteByUserAndGroup(TUserGroup userGroup) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("user_id", userGroup.getUserId());
        map.put("group_id", userGroup.getGroupId());
        if (userGroupMapper.deleteByUserAndGroup(map) > 0) {
            map.clear();
            map.put("code", 200);
        } else {
            map.clear();
            map.put("code", 216);
            map.put("message", "删除失败,请检查用户传入id是否正确");
        }
        return map;
    }
}
