package personal.mapper;

public interface TBaseMapper<T, PK> {

    Integer deleteById(PK id);

    Integer insert(T t);

    int insertSelective(T t);

    T getById(PK id);

    int updateByIdSelective(T t);

    int updateById(T t);
}
