package net.javacrud.springboot_restful_webservices.mapper;

import net.javacrud.springboot_restful_webservices.dto.UserDto;
import net.javacrud.springboot_restful_webservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);//implemetation at compilation time
    //@Mapping(source = "email", target = "emailAddress") if the mapping in User and  UserDto are different
    UserDto maptouserDto(User user);
    User mapToUser(UserDto userDto);
}
