package personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.entity.TUser;
import personal.mapper.TBaseMapper;
import personal.mapper.TUserMapper;
import personal.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<TUser, String> implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public TBaseMapper<TUser, String> getBaseMapper() {
        return userMapper;
    }
}
