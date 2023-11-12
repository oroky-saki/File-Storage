package com.vavilov.filestorage.mapper;

import com.vavilov.filestorage.dto.ReturnedUserDto;
import com.vavilov.filestorage.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    ReturnedUserDto toDto(UserEntity userEntity);
}
