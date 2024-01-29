package com.github.mullerdaniil.trinculo.engine.mapper;

public interface Mapper<T, U> {
    U map(T object);
}
