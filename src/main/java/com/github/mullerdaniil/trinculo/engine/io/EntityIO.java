package com.github.mullerdaniil.trinculo.engine.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mullerdaniil.trinculo.engine.exception.EntityIOException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public abstract class EntityIO<T> {
    @Autowired
    private ObjectMapper objectMapper;

    public final List<T> read() throws EntityIOException {
        try {
            var collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, getEntityClass());
            return objectMapper.readValue(getEntitiesFilePath().toFile(), collectionType);
        } catch (IOException e) {
            throw new EntityIOException("Can't read entities.", e);
        }
    }

    public final void write(List<T> entities) throws EntityIOException {
        try {
            objectMapper.writeValue(getEntitiesFilePath().toFile(), entities);
        } catch (IOException e) {
            throw new EntityIOException("Can't write entities.", e);
        }
    }

    protected abstract Path getEntitiesFilePath();

    protected abstract Class<T> getEntityClass();
}
