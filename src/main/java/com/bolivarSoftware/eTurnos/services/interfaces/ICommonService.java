package com.bolivarSoftware.eTurnos.services.interfaces;

import java.util.List;

public interface ICommonService<T,ID> {

    T get(final ID id);

    T save(final T t);

    List<T> findAll();
}
