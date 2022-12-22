package com.banque.misr.irrigation.system.serviceimpl;

import com.banque.misr.irrigation.system.service.ObjectMapper;
import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ObjectMapperImpl implements ObjectMapper {

    private final ModelMapper mapper = getModelMapper();

    private ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD).setAmbiguityIgnored(true);
        mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
        return mapper;
    }

    public <S, T> Page<T> mapPage(Page<S> source, Class<T> targetClass) {
        return source.map(element -> mapper.map(element, targetClass));
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        ArrayList<T> result = new ArrayList<>();
        for (S element : source) {
            result.add(mapper.map(element, targetClass));
        }
        return result;
    }

    public <D> D map(Object source, Class<D> destinationType) {
        return mapper.map(source, destinationType);
    }

    public void map(Object source, Object destination) {
        mapper.map(source, destination);
    }

}
