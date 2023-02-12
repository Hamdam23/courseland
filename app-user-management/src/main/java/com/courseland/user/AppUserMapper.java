package com.courseland.user;

import com.courseland.user.dtos.AppUserRequestDTO;
import com.courseland.user.dtos.AppUserResponseDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AppUserMapper {

    @Mapping(target = "id", ignore = true)
    AppUser toEntity(AppUserRequestDTO request);

    AppUserResponseDTO toResponse(AppUser user);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(AppUserRequestDTO request, @MappingTarget AppUser user);
}
