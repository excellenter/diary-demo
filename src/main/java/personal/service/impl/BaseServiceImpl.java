package personal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import personal.mapper.TBaseMapper;
import personal.service.BaseService;

public class BaseServiceImpl<T, PK> implements BaseService<T, PK> {

    @Autowired
    private TBaseMapper<T, PK> baseMapper;

    @Override
    public Integer deleteById(PK id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Integer insert(T t) {
        return baseMapper.insert(t);
    }

    @Override
    public Integer insertSelective(T t) {
        return baseMapper.insertSelective(t);
    }

    @Override
    public T getById(PK id) {
        return baseMapper.getById(id);
    }

    @Override
    public Integer updateByIdSelective(T t) {
        return baseMapper.updateByIdSelective(t);
    }

    @Override
    public Integer updateById(T t) {
        return baseMapper.updateById(t);
    }
}
