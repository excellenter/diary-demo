package personal.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface BaseService<T, ID> {

    Map<String, Object> insert(T t);

    Map<String, Object> deleteBatchInId(String ids);

    Map<String, Object> deleteInId(ID id);

    Map<String, Object> update(T t);

    T getInId(ID id);

    List<T> listInIds(String ids);

    PageInfo<T> list(Integer pageNo, Integer pageSize);
}
