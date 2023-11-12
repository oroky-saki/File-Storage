package com.vavilov.filestorage.controller;

import com.vavilov.filestorage.dto.ReturnedUserDto;
import com.vavilov.filestorage.dto.UserDto;
import com.vavilov.filestorage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @PutMapping("/registration")
    public ResponseEntity<ReturnedUserDto> createUser(@RequestBody UserDto user) {
        return ResponseEntity.status(201).body(userService.createUser(user));
    }

    @GetMapping("/info")
    public ResponseEntity<ReturnedUserDto> getUserInfo(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(userService.getUserInfo(id));
    }

}
