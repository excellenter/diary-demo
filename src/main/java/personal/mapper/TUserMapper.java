package personal.mapper;

import personal.entity.TUser;

import java.util.Map;

public interface TUserMapper extends TBaseMapper<TUser, String> {

    //邮箱账号查询
    TUser getUserByEmail(Map<String, Object> map);

    //手机账号查询
    TUser getUserByTel(Map<String, Object> map);
}