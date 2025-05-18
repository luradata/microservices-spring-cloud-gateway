package com.luradata.user_service.grpc;

import com.luradata.user_service.proto.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class UserGrpcServer {
    private Server server;

    @Value("${grpc.server.port:9090}")
    private int port;

    @PostConstruct
    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new UserServiceImpl())
                .build()
                .start();
        log.info("gRPC Server started, listening on port {}", port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                UserGrpcServer.this.stop();
            } catch (InterruptedException e) {
                log.error("Error stopping gRPC server", e);
            }
        }));
    }

    @PreDestroy
    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private static class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
        @Override
        public void getUser(GetUserRequest request, StreamObserver<UserResponse> responseObserver) {
            // TODO: Implement actual user retrieval logic
            UserResponse response = UserResponse.newBuilder()
                    .setUserId(request.getUserId())
                    .setUsername("test_user")
                    .setEmail("test@example.com")
                    .setFullName("Test User")
                    .setCreatedAt("2024-03-20T10:00:00Z")
                    .setUpdatedAt("2024-03-20T10:00:00Z")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void createUser(CreateUserRequest request, StreamObserver<UserResponse> responseObserver) {
            // TODO: Implement actual user creation logic
            UserResponse response = UserResponse.newBuilder()
                    .setUserId(1L)
                    .setUsername(request.getUsername())
                    .setEmail(request.getEmail())
                    .setFullName(request.getFullName())
                    .setCreatedAt("2024-03-20T10:00:00Z")
                    .setUpdatedAt("2024-03-20T10:00:00Z")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void updateUser(UpdateUserRequest request, StreamObserver<UserResponse> responseObserver) {
            // TODO: Implement actual user update logic
            UserResponse response = UserResponse.newBuilder()
                    .setUserId(request.getUserId())
                    .setUsername(request.getUsername())
                    .setEmail(request.getEmail())
                    .setFullName(request.getFullName())
                    .setCreatedAt("2024-03-20T10:00:00Z")
                    .setUpdatedAt("2024-03-20T10:00:00Z")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void deleteUser(DeleteUserRequest request, StreamObserver<DeleteUserResponse> responseObserver) {
            // TODO: Implement actual user deletion logic
            DeleteUserResponse response = DeleteUserResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("User deleted successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
} 