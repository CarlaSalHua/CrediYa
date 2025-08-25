package co.com.bancolombia.api.mapper;

import co.com.bancolombia.api.dto.UserDTO;
import co.com.bancolombia.model.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToDTO(User user);
    User userToEntity(UserDTO userDTO);
}
