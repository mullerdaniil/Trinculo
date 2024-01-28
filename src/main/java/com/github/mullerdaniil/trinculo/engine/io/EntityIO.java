package com.github.mullerdaniil.trinculo.engine.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public abstract class EntityIO<T> {
    @Autowired
    private ObjectMapper objectMapper;

    public final List<T> read() throws IOException {
        var collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, getEntityClass());
        return objectMapper.readValue(getEntitiesFilePath().toFile(), collectionType);
    }

    public final void write(List<T> entities) throws IOException {
        objectMapper.writeValue(getEntitiesFilePath().toFile(), entities);
    }

    protected abstract Path getEntitiesFilePath();

    protected abstract Class<T> getEntityClass();
}
