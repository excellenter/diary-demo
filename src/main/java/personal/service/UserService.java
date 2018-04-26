package personal.service;

import personal.entity.TUser;

import java.util.Map;

public interface UserService extends BaseService<TUser, String> {

    TUser getUserByTel(String tel);

    TUser getUserByEmail(String email);

    Map<String, Object> loginByTel(String tel, String password);

    Map<String, Object> loginByEmail(String email, String password);
}
