package personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.entity.TUser;
import personal.mapper.TUserGroupMapper;
import personal.mapper.TUserMapper;
import personal.mapper.TUserRoleMapper;
import personal.service.UserService;
import personal.tool.MD5;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<TUser, String> implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private TUserRoleMapper userRoleMapper;

    @Autowired
    private TUserGroupMapper userGroupMapper;

    @Override
    public Map<String, Object> insert(TUser user) {
        Map<String, Object> map = new HashMap<>(4);
        // password secret
        String newPassword = MD5.md5(user.getPassword());
        user.setPassword(newPassword);
        // build token
        user.setToken(MD5.md5(user.getTel() + user.getPassword() + System.currentTimeMillis() + "salt"));
        if (userMapper.insert(user) > 0) {
            map.put("code", 200);
        } else {
            map.put("code", 216);
            map.put("message", "Id or 手机号码 or email信息重复");
        }
        return map;
    }

    @Override
    public TUser getUserByTel(String tel) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("tel", tel);
        return userMapper.getUserByTel(map);
    }

    @Override
    public TUser getUserByEmail(String email) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("email", email);
        return userMapper.getUserByEmail(map);
    }

    @Override
    public Map<String, Object> loginByTel(String tel, String password) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("tel", tel);
        map.put("password", MD5.md5(password));
        TUser user = userMapper.getUserByTel(map);
        map.clear();
        if (null != user) {
            generateUserMap(user, map);
        } else {
            map.put("code", 216);
            map.put("message", "手机号码不存在或密码错误");
        }
        return map;
    }

    @Override
    public Map<String, Object> loginByEmail(String email, String password) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("email", email);
        map.put("password", MD5.md5(password));
        TUser user = userMapper.getUserByEmail(map);
        map.clear();
        if (null != user) {
            generateUserMap(user, map);
        } else {
            map.put("code", 216);
            map.put("message", "邮箱不存在或密码错误");
        }
        return map;
    }

    /**
     * 封装用户信息
     *
     * @param user
     * @param map
     */
    private void generateUserMap(TUser user, Map<String, Object> map) {
        map.put("code", 200);
        map.put("message", "登陆成功");
        map.put("user", user);
        //获取角色
        map.put("role", userRoleMapper.getRoleByUser(user.getId()));
        //获取群组
        map.put("group", userGroupMapper.getGroupByUser(user.getId()));
    }
}
