package com.banque.misr.irrigation.system.service;

import org.springframework.data.domain.Page;

public interface ObjectMapper {

    <S, T> Page<T> mapPage(Page<S> source, Class<T> targetClass);

    <D> D map(Object source, Class<D> destinationType);

    void map(Object source, Object destination);

}
