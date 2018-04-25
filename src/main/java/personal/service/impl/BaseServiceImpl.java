package personal.service.impl;

import personal.mapper.TBaseMapper;
import personal.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    public BaseServiceImpl() {
    }

    public abstract TBaseMapper<T, ID> getBaseMapper();

    @Override
    public Integer insert(T t) {
        return getBaseMapper().insert(t);
    }

    @Override
    public Integer insertBatch(List<T> ts) {
        return getBaseMapper().insertBatch(ts);
    }

    @Override
    public Integer deleteBatchInId(List<ID> ids) {
        return getBaseMapper().deleteBatchInId(ids);
    }

    @Override
    public Integer deleteInId(ID id) {
        return getBaseMapper().deleteInId(id);
    }

    @Override
    public Integer update(T t) {
        return getBaseMapper().update(t);
    }

    @Override
    public Integer updateBatch(List<T> ts) {
        return getBaseMapper().updateBatch(ts);
    }

    @Override
    public T getInId(ID id) {
        return getBaseMapper().getInId(id);
    }

    @Override
    public List<T> listInIds(List<ID> ids) {
        return getBaseMapper().listInIds(ids);
    }

    @Override
    public List<T> list() {
        return getBaseMapper().list();
    }

    @Override
    public Long countInId(ID id) {
        return getBaseMapper().countInId(id);
    }
}
