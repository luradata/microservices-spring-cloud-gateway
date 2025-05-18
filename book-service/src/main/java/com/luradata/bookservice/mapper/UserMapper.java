package com.luradata.bookservice.mapper;

import com.luradata.bookservice.proto.UserResponse;
import com.luradata.bookservice.dto.UserDto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    
    public static UserDto toDTO(UserResponse response) {
        return UserDto.builder()
                .userId(response.getUserId())
                .username(response.getUsername())
                .email(response.getEmail())
                .fullName(response.getFullName())
                .createdAt(response.getCreatedAt())
                .updatedAt(response.getUpdatedAt())
                .build();
    }
} 