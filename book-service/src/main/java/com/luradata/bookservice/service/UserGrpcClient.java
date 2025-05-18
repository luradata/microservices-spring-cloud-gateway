package com.luradata.bookservice.service;

import com.luradata.bookservice.proto.*;
import com.luradata.bookservice.dto.UserDto;
import com.luradata.bookservice.mapper.UserMapper;

import io.grpc.ManagedChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserGrpcClient {
    private final UserServiceGrpc.UserServiceBlockingStub blockingStub;

    public UserGrpcClient(ManagedChannel channel) {
        this.blockingStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public UserDto getUser(Long userId) {
        try {
            GetUserRequest request = GetUserRequest.newBuilder()
                    .setUserId(userId)
                    .build();
            UserResponse response = blockingStub.getUser(request);
            return UserMapper.toDTO(response);
        } catch (Exception e) {
            log.error("Error getting user: {}", e.getMessage());
            throw new RuntimeException("Failed to get user", e);
        }
    }

    public UserDto createUser(String username, String email, String fullName) {
        try {
            CreateUserRequest request = CreateUserRequest.newBuilder()
                    .setUsername(username)
                    .setEmail(email)
                    .setFullName(fullName)
                    .build();
            UserResponse response = blockingStub.createUser(request);
            return UserMapper.toDTO(response);
        } catch (Exception e) {
            log.error("Error creating user: {}", e.getMessage());
            throw new RuntimeException("Failed to create user", e);
        }
    }

    public UserDto updateUser(Long userId, String username, String email, String fullName) {
        try {
            UpdateUserRequest request = UpdateUserRequest.newBuilder()
                    .setUserId(userId)
                    .setUsername(username)
                    .setEmail(email)
                    .setFullName(fullName)
                    .build();
            UserResponse response = blockingStub.updateUser(request);
            return UserMapper.toDTO(response);
        } catch (Exception e) {
            log.error("Error updating user: {}", e.getMessage());
            throw new RuntimeException("Failed to update user", e);
        }
    }

    public boolean deleteUser(Long userId) {
        try {
            DeleteUserRequest request = DeleteUserRequest.newBuilder()
                    .setUserId(userId)
                    .build();
            DeleteUserResponse response = blockingStub.deleteUser(request);
            return response.getSuccess();
        } catch (Exception e) {
            log.error("Error deleting user: {}", e.getMessage());
            throw new RuntimeException("Failed to delete user", e);
        }
    }
} 