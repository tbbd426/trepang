package com.github.trepang.dao;

import java.util.List;
import java.util.Optional;

/**
 * @author tianbing
 */
public abstract class AbstractDao {

    protected static <T> Optional<T> firstOrEmpty(List<T> elems) {
        if (elems.size() > 0) {
            return Optional.of(elems.get(0));
        }
        return Optional.empty();
    }
}
