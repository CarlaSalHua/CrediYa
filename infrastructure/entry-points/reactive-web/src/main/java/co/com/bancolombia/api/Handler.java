package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.UserDTO;
import co.com.bancolombia.api.mapper.UserMapper;
import co.com.bancolombia.model.user.User;
import co.com.bancolombia.usecase.registeruser.RegisterUserUseCase;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private  final RegisterUserUseCase registerUserUseCase;
    private final UserMapper userMapper;

    public Mono<ServerResponse> listenSaveUser(ServerRequest serverRequest) {
        // useCase.logic();
        return serverRequest.bodyToMono(UserDTO.class)
                .map(userMapper::userToEntity)
                .flatMap(registerUserUseCase::saveUser)
                .flatMap(savedUser -> ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(savedUser));
    }

    //metodos
    public  Mono<User> safeUser(@RequestBody(description = "userDTO") UserDTO userDTO) {
        return Mono.empty();
    }
}
