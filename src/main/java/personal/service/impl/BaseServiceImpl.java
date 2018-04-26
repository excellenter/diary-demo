package personal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import personal.mapper.TBaseMapper;
import personal.service.BaseService;

import java.util.*;

public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    public BaseServiceImpl() {
    }

    public abstract TBaseMapper<T, ID> getBaseMapper();

    @Override
    public Map<String, Object> insert(T t) {
        Map<String, Object> map = new HashMap<>(4);
        if (getBaseMapper().insert(t) > 0) {
            map.put("code", 200);
        } else {
            map.put("code", 216);
            map.put("message", "创建失败,请检查传入信息是否重复");
        }
        return map;
    }

    @Override
    public Map<String, Object> deleteBatchInId(String ids) {
        if (ids.contains(",")) {
            Map<String, Object> map = new HashMap<>(4);
            List<ID> list = new ArrayList<>();
            for (ID id : (ID[]) ids.split(",")) {
                list.add(id);
            }
            if (getBaseMapper().deleteBatchInId(list) > 0) {
                map.put("code", 200);
            } else {
                map.put("code", 216);
                map.put("message", "删除失败,请检查传入Id是否正确");
            }
            return map;
        } else {
            deleteInId((ID) ids);
        }
        return null;
    }

    @Override
    public Map<String, Object> deleteInId(ID id) {
        Map<String, Object> map = new HashMap<>(4);
        if (getBaseMapper().deleteInId(id) > 0) {
            map.put("code", 200);
        } else {
            map.put("code", 216);
            map.put("message", "删除失败,请检查传入Id是否正确");
        }
        return map;
    }

    @Override
    public Map<String, Object> update(T t) {
        Map<String, Object> map = new HashMap<>(4);
        if (getBaseMapper().update(t) > 0) {
            map.put("code", 200);
        } else {
            map.put("code", 216);
            map.put("message", "更新失败,请检查传入Id是否正确");
        }
        return map;
    }

    @Override
    public T getInId(ID id) {
        return getBaseMapper().getInId(id);
    }

    @Override
    public List<T> listInIds(String ids) {
        List<ID> list = new ArrayList<>();
        for (ID id : (ID[]) ids.split(",")) {
            list.add(id);
        }
        return getBaseMapper().listInIds(list);
    }

    @Override
    public PageInfo<T> list(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<T> pageInfo = new PageInfo<>(getBaseMapper().list());
        return pageInfo;
    }
}
