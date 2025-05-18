package com.luradata.bookservice.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class UserDto {
    private Long userId;
    private String username;
    private String email;
    private String fullName;
    private String createdAt;
    private String updatedAt;
} 