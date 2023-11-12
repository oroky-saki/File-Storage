package com.vavilov.filestorage.service;

import com.vavilov.filestorage.dto.ReturnedUserDto;
import com.vavilov.filestorage.dto.UserDto;
import com.vavilov.filestorage.exceptions.UserAlreadyExistException;
import com.vavilov.filestorage.exceptions.UserIsNotExistsException;
import com.vavilov.filestorage.mapper.UserMapper;
import com.vavilov.filestorage.model.Role;
import com.vavilov.filestorage.model.UserEntity;
import com.vavilov.filestorage.repository.RoleRepo;
import com.vavilov.filestorage.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final UserMapper userMapper;

    public ReturnedUserDto createUser(UserDto dto) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String email = dto.getEmail();
        String username = dto.getUsername();
        String password = passwordEncoder.encode(dto.getPassword());

        Collection<Role> roles = List.of(roleRepo.findById(1L).get());
        UserEntity user = new UserEntity(
                email,
                username,
                password
        );
        user.setRoles(roles);
        if (userRepo.findByUsername(username) != null) {
            throw new UserAlreadyExistException(String.format("User with username '%s' Already Exists!"));
        }
        var x = userRepo.save(user);
        var y = userMapper.toDto(x);
        return y;
    }

    public ReturnedUserDto getUserInfo(Long id) {
        UserEntity user = userRepo.findById(id)
                .orElseThrow(() -> new UserIsNotExistsException(String.format("User with ID '%d' is Not Exists!", id)));
        return userMapper.toDto(user);
    }
}
