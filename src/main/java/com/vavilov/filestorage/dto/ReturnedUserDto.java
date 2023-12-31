package com.vavilov.filestorage.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ReturnedUserDto {
    private Long id;
    private String email;
    private String username;
}
