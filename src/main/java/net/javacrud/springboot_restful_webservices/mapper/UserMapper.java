package net.javacrud.springboot_restful_webservices.mapper;

import net.javacrud.springboot_restful_webservices.dto.UserDto;
import net.javacrud.springboot_restful_webservices.entity.User;

public class UserMapper {

//Convert User JPA entity into UserDto
public static UserDto mapToUserDto(User user) {
    UserDto userDto = new UserDto(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail()
    );
    return userDto;
}
//Convert UserDto JPA entity into User
    public static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
          return user;

    }


}
