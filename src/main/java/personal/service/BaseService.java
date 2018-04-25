package personal.service;

import java.util.List;

public interface BaseService<T, ID> {

    Integer insert(T t);

    Integer insertBatch(List<T> ts);

    Integer deleteBatchInId(List<ID> ids);

    Integer deleteInId(ID id);

    Integer update(T t);

    Integer updateBatch(List<T> ts);

    T getInId(ID id);

    List<T> listInIds(List<ID> ids);

    /**
     * 查询所有(无分页慎用)
     *
     * @return
     */
    List<T> list();

    Long countInId(ID id);
}
