package personal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.mapper.TBaseMapper;
import personal.service.BaseService;

import java.util.*;

@Service
public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

    @Autowired
    private TBaseMapper<T, ID> baseMapper;

    @Override
    public Map<String, Object> insert(T t) {
        Map<String, Object> map = new HashMap<>(4);
        if (baseMapper.insert(t) > 0) {
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
            if (baseMapper.deleteBatchInId(list) > 0) {
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
        if (baseMapper.deleteInId(id) > 0) {
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
        if (baseMapper.update(t) > 0) {
            map.put("code", 200);
        } else {
            map.put("code", 216);
            map.put("message", "更新失败,请检查传入Id是否正确");
        }
        return map;
    }

    @Override
    public T getInId(ID id) {
        return baseMapper.getInId(id);
    }

    @Override
    public List<T> listInIds(String ids) {
        List<ID> list = new ArrayList<>();
        for (ID id : (ID[]) ids.split(",")) {
            list.add(id);
        }
        return baseMapper.listInIds(list);
    }

    @Override
    public PageInfo<T> list(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<T> pageInfo = new PageInfo<>(baseMapper.list());
        return pageInfo;
    }
}
