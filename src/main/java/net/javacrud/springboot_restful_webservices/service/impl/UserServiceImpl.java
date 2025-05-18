package net.javacrud.springboot_restful_webservices.service.impl;

import lombok.AllArgsConstructor;

import net.javacrud.springboot_restful_webservices.dto.UserDto;
import net.javacrud.springboot_restful_webservices.entity.User;
import net.javacrud.springboot_restful_webservices.exception.EmailAlreadyExistsException;
import net.javacrud.springboot_restful_webservices.exception.ResourceNotFoundException;
import net.javacrud.springboot_restful_webservices.mapper.AutoUserMapper;
import net.javacrud.springboot_restful_webservices.mapper.UserMapper;
import net.javacrud.springboot_restful_webservices.repository.UserRepository;
import net.javacrud.springboot_restful_webservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
@AllArgsConstructor//UserServiceImpl UserRepository userRepository-parameterized constuctor hence no need to use @Autowired annotation
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;



    @Override
    public UserDto createUser(UserDto userDto) {
        //Convert UserDto into User JPA Entity
//        User user = new User(
//                userDto.getId(),
//                userDto.getFirstName(),
//                userDto.getLastName(),
//                userDto.getEmail()
//        );
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }

       //  User user = modelMapper.map(userDto, User.class);
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
      //  User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        //Convert UserJPA entity to user DTO
     //   UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
//        UserDto savedUserDto = new UserDto(
//                savedUser.getId(),
//                savedUser.getFirstName(),
//                savedUser.getLastName(),
//                savedUser.getEmail()
//        );
      //  UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.maptouserDto(savedUser);
              return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
       // Optional<User> optionalUser = userRepository.findById(userId);
        User user =userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", userId)
        );
      // User user =optionalUser.get();
     //  return UserMapper.mapToUserDto(user);
      //  return  modelMapper.map(user, UserDto.class);
        //return  AutoUserMapper.MAPPER.maptouserDto(optionalUser.get());
        return  AutoUserMapper.MAPPER.maptouserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        return users.stream().map(UserMapper::mapToUserDto)
//                .collect(Collectors.toList());
       return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
              .collect(Collectors.toList());
       // return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user))
         //       .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
   //     User existingUser = userRepository.findById(user.getId()).get();
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id" , user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        //return UserMapper.mapToUserDto(updatedUser);
        return modelMapper.map(updatedUser, UserDto.class);
//return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id" , userId)
        );
        userRepository.deleteById(userId);
    }
}
