package com.payment.service.mapper;


import com.payment.dto.BaseDto;
import com.payment.entity.BaseEntity;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

public interface BaseMapper<Entity extends BaseEntity, Dto extends BaseDto> {

    Dto entityToDto(Entity entity);

    Entity dtoToEntity(Dto dto);

    @Named("forSave")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    Entity dtoToEntityForSave(Dto dto);

    List<Dto> entityListToDtoList(List<Entity> list);
    List<Entity> dtoListToEntityList(List<Dto> list);

}
