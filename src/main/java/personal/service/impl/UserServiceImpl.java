package personal.service.impl;

import org.springframework.stereotype.Service;
import personal.entity.TUser;
import personal.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<TUser, String> implements UserService {
}
