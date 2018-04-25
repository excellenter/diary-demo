package personal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBaseMapper<T, ID> {

    Integer insert(T t);

    Integer insertBatch(@Param("ts") List<T> ts);

    Integer deleteBatchInId(@Param("ids") List<ID> ids);

    Integer deleteInId(ID id);

    Integer update(T t);

    Integer updateBatch(@Param("ts") List<T> ts);

    T getInId(ID id);

    List<T> listInIds(@Param("ids") List<ID> ids);

    /**
     * 查询所有(无分页慎用)
     *
     * @return
     */
    List<T> list();

    Long countInId(ID id);
}
