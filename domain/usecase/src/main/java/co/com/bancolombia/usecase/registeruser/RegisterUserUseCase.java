package co.com.bancolombia.usecase.registeruser;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RegisterUserUseCase {
    private final UserRepository userRepository;

    public Mono<User> saveUser(User user) {
        try {
            return userRepository.existsByEmail(user.getEmail())
                    .flatMap( exists -> {
                        if(exists) {
                            return Mono.error(new IllegalArgumentException("The email is already registered"));
                        }
                        return userRepository.save(user);
                    });
        } catch (Exception ex) {
            return null;
        }
    }
}
