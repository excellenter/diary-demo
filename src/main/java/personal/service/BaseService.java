package personal.service;

public interface BaseService<T, PK> {
    Integer deleteById(PK id);

    Integer insert(T t);

    Integer insertSelective(T t);

    T getById(PK id);

    Integer updateByIdSelective(T t);

    Integer updateById(T t);
}
