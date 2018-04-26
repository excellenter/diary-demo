package personal.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBaseMapper<T, ID> {

    Integer insert(T t);

    Integer deleteBatchInId(@Param("ids") List<ID> ids);

    Integer deleteInId(ID id);

    Integer update(T t);

    T getInId(ID id);

    List<T> listInIds(@Param("ids") List<ID> ids);

    List<T> list();
}
