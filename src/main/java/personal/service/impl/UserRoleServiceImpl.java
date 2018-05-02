package personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.entity.TUserRole;
import personal.mapper.TUserRoleMapper;
import personal.service.UserRoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRoleServiceImpl extends BaseServiceImpl<TUserRole, Long> implements UserRoleService {

    @Autowired
    private TUserRoleMapper userRoleMapper;

    @Override
    public List<Map<String, Object>> getRoleByUser(String userId) {
        return userRoleMapper.getRoleByUser(userId);
    }

    @Override
    public Map<String, Object> deleteByUser(String userId) {
        Map<String, Object> map = new HashMap<>(4);
        if ("".equals(userId) || userId == null) {
            map.put("code", 516);
            map.put("message", "传入参数错误");
            return map;
        }
        if (userRoleMapper.deleteByUser(userId) > 0) {
            map.put("code", 200);
        } else {
            map.put("code", 216);
            map.put("message", "删除失败,请检查用户id是否正确");
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteNyUserAndRole(TUserRole userRole) {
        Map<String, Object> map = new HashMap<>(4);
        if (!(userRole.getRoleId() != null && userRole.getRoleId() != 0 && userRole.getUserId() != null && userRole.getUserId() != "")) {
            map.put("code", 516);
            map.put("message", "传入参数错误");
            return map;
        }
        map.put("user_id", userRole.getUserId());
        map.put("role_id", userRole.getRoleId());
        if (userRoleMapper.deleteByUserAndRole(map) > 0) {
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
