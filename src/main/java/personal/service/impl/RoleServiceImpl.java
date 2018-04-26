package personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.entity.TRole;
import personal.mapper.TBaseMapper;
import personal.mapper.TRoleMapper;
import personal.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<TRole, Long> implements RoleService {

    @Autowired
    private TRoleMapper roleMapper;

    @Override
    public TBaseMapper<TRole, Long> getBaseMapper() {
        return roleMapper;
    }
}
